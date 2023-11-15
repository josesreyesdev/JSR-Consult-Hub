package com.jsrdev.jsrconsulthub.ui.medic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jsrdev.jsrconsulthub.R
import com.jsrdev.jsrconsulthub.data.network.model.medic.GetMedicResponse
import com.jsrdev.jsrconsulthub.databinding.FragmentMedicBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

const val TAG = "MedicFragment"
class MedicFragment : Fragment() {

    private var _binding: FragmentMedicBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    private lateinit var adapter: MedicAdapter

    private val viewModel: MedicViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getMedics()

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    invalidate(state)
                }
            }
        }

        searchMedic(viewModel.state.value.success)

    }

    private fun invalidate(state: MedicState) {

        if (state.isLoading) {
            binding.imageState.visibility = View.VISIBLE // img loading visible
            binding.imageState.setImageResource(R.drawable.loading_animation)
        }

        if (state.success.isNotEmpty()) {
            binding.imageState.visibility = View.GONE // img loading invisible
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
            adapterMedic(state.success)
        }

        if (state.error != null) {
            binding.imageState.visibility = View.VISIBLE
            binding.imageState.setImageResource(R.drawable.ic_connection_error)
        }
    }

    private fun adapterMedic( medicList: List<GetMedicResponse>) {
        val recyclerView = binding.recyclerView
        //recyclerView.adapter = MedicAdapter{it, medicList}
        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }
    private fun searchMedic(listMedics: List<GetMedicResponse>) {
        binding.searchEditText.addTextChangedListener { medicFilter ->
            Log.i(TAG, medicFilter.toString())
            val medicFiltered = listMedics.filter { medic ->
                medic.name.lowercase().contains(medicFilter.toString().lowercase())
            }
            adapter.updateMedic(medicFiltered)
        }
    }
}