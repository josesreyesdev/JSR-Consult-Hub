package com.jsrdev.jsrconsulthub.ui.medic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.jsrdev.jsrconsulthub.R
import com.jsrdev.jsrconsulthub.databinding.FragmentAddMedicBinding
import com.jsrdev.jsrconsulthub.domain.usecases.Specialty

class AddMedicFragment : Fragment() {

    private var _binding: FragmentAddMedicBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddMedicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        selectSpecialty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun selectSpecialty() {
        val specialties = Specialty.entries.map { it.name }
        val adapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, specialties)

        val specialty = binding.autocompleteSpecialtyEditText

        specialty.setAdapter(adapter)

        specialty.setOnItemClickListener { parent, _/*view*/, position, _/*id*/ ->
            val selectedItem = parent.adapter.getItem(position).toString()
            Toast.makeText(requireContext(), selectedItem, Toast.LENGTH_SHORT).show()
        }
    }

}