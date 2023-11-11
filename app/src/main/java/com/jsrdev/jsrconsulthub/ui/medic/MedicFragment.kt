package com.jsrdev.jsrconsulthub.ui.medic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.jsrdev.jsrconsulthub.databinding.FragmentMedicBinding

const val TAG = "MedicFragment"
class MedicFragment : Fragment() {

    private var _binding: FragmentMedicBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    private lateinit var adapter: MedicAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchEditText.addTextChangedListener {medicFilter ->
            Log.i(TAG, medicFilter.toString())
            val list = listOf("Alejandro", "Ala", "Bar", "barbie", "Carlos", "Diego", "Estefany")
            val medicFiltered = list.filter { medic ->
                medic.lowercase()./*name.*/contains(medicFilter.toString().lowercase())
            }
            //adapter.updateMedic(medicFiltered)
        }
    }

}