package com.jsrdev.jsrconsulthub.ui.medic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
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
    /*private val viewModel: MedicViewModel by activityViewModels {
        MedicViewModelFactory((activity?.application as MedicViewModelFactory).database.medicDao())
    } */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collectLatest { state ->
                    invalidate(state)
                }
            }
        }
        searchMedic(viewModel.state.value.success)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

        // Limpiar el adaptador para liberar recursos
        if (::adapter.isInitialized) adapter.submitList(null)
    }

    private fun invalidate(state: MedicState) {

        if (state.isLoading) {
            binding.imageState.visibility = View.VISIBLE // visible
            binding.imageState.setImageResource(R.drawable.loading_animation)
        }

        if (state.success.isNotEmpty()) {
            binding.imageState.visibility = View.GONE // invisible
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

            adapterMedic(state.success)
        }

        if (state.error != null) {
            binding.imageState.visibility = View.VISIBLE
            binding.imageState.setImageResource(R.drawable.ic_connection_error)
        }
    }

    private fun adapterMedic(medicList: List<GetMedicResponse>) {

        if (!::adapter.isInitialized) {
            adapter = MedicAdapter(medicList)
            /*adapter = MedicAdapter2({
            val action = DetailMedicFragmentDirections.actionDetailMedicFragmentToDetailMedicFragment(
                id = it.id
            )
            view.findNavController().navigate(action)
        }) */

            binding.recyclerView.adapter = adapter
        }
        adapter.submitList(medicList)
    }
    private fun searchMedic(listMedics: List<GetMedicResponse>) {
        binding.searchEditText.addTextChangedListener { medicFilter ->
            val medicFiltered: List<GetMedicResponse> = listMedics.filter { medic ->
                medic.name?.lowercase()?.contains(medicFilter.toString().lowercase()) ?: false
            }
            adapter.updateMedic(medicFiltered)
        }
    }
}