
package com.jsrdev.jsrconsulthub.ui.medic

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsrdev.jsrconsulthub.core.Constants
import com.jsrdev.jsrconsulthub.data.network.model.medic.GetMedicResponse
import com.jsrdev.jsrconsulthub.data.network.services.MedicService
import com.jsrdev.jsrconsulthub.data.repository.MedicModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class MedicState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val success: List<GetMedicResponse> = emptyList()
)

class MedicViewModel(
    private val medicRepository: MedicService = MedicModule.provideRepository()
): ViewModel() {

    private val internalState = MutableStateFlow(MedicState())
    val state: StateFlow<MedicState> = internalState

    fun getMedics() {
        internalState.value = internalState.value.copy(
            isLoading = true
        )
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val medics = medicRepository.getMedics(token = Constants.TOKEN_CONSULT_HUB)
                Log.i(TAG, medics.body().toString())
                internalState.value = internalState.value.copy(
                    isLoading = false,
                    error = if (medics.isSuccessful) null else RuntimeException("NOT FOUND MEDIC LIST"),
                    success = medics.body() ?: emptyList()
                )
            } catch (ex: Exception) {
                Log.i(TAG, "error: $ex")
                internalState.value = internalState.value.copy(
                    isLoading = false,
                    error = RuntimeException("Failure: ${ex.message}"), // error = ex
                    success = listOf()
                )
            }
        }
    }
}

/*
* class MedicViewModelFactory(private val medicDao: MedicDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MedicViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MedicViewModel(medicDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class / no se encontro la clase viewModel")
    }
}
* */