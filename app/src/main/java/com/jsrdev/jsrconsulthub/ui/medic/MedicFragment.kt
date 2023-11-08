package com.jsrdev.jsrconsulthub.ui.medic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsrdev.jsrconsulthub.databinding.FragmentMedicBinding


class MedicFragment : Fragment() {

    private var _binding: FragmentMedicBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicBinding.inflate(inflater, container, false)
        return binding.root
    }

}