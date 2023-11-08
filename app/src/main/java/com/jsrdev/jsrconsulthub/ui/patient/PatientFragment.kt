package com.jsrdev.jsrconsulthub.ui.patient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsrdev.jsrconsulthub.databinding.FragmentPatientBinding

class PatientFragment : Fragment() {

    private var _binding: FragmentPatientBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPatientBinding.inflate(inflater, container, false)
        return binding.root
    }

}