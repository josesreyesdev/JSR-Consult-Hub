package com.jsrdev.jsrconsulthub.ui.consult

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jsrdev.jsrconsulthub.R
import com.jsrdev.jsrconsulthub.databinding.FragmentAddConsultBinding

class AddConsultFragment : Fragment() {

    private var _binding: FragmentAddConsultBinding? = null
    private val binding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddConsultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dateEditText.setOnClickListener { showDatePickerDialog() }
        binding.timeEditText.setOnClickListener { showTimePickerDialog() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year ->
            onDateSelected(day, month, year)
        }
        datePicker.show(parentFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        binding.dateEditText.setText(getString(R.string.date_text, day, month, year))
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment { hour, minute ->
            onTimeSelected(hour, minute)
        }
        timePicker.show(parentFragmentManager, "timePicker")
    }

    private fun onTimeSelected(hour: Int, minute: Int) {
        val amPm: String
        val displayHour: Int

        if (hour >= 12) {
            amPm = "PM"
            displayHour = if (hour > 12) hour - 12 else hour
        } else {
            amPm = "AM"
            displayHour = if (hour == 0) 12 else hour
        }
        binding.timeEditText.setText(getString(R.string.time_text, displayHour, minute, amPm))
    }

}