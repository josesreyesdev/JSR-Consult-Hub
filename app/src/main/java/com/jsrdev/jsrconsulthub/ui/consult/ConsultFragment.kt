package com.jsrdev.jsrconsulthub.ui.consult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsrdev.jsrconsulthub.databinding.FragmentConsultBinding

class ConsultFragment : Fragment() {

    private var _binding: FragmentConsultBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConsultBinding.inflate(inflater, container, false)
        return binding.root
    }

}