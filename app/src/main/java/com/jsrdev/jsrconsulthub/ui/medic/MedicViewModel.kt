
package com.jsrdev.jsrconsulthub.ui.medic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jsrdev.jsrconsulthub.data.network.api.ConsultHubApi
import com.jsrdev.jsrconsulthub.data.network.model.medic.MedicResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class MedicState(
    val isLoading: Boolean = false,
    val error: Throwable? = null,
    val medicList: List<MedicResponse> = emptyList()
)

class MedicViewModel: ViewModel() {

    private val internalState = MutableStateFlow(MedicState())
    val state: StateFlow<MedicState> = internalState

    init {
        getMedics()
    }

    private fun getMedics() {
        internalState.value = internalState.value.copy(
            isLoading = true
        )
        viewModelScope.launch(Dispatchers.IO) {

            val medics = ConsultHubApi.retrofitMedicService.getMedics()
            internalState.value = internalState.value.copy(
                isLoading = false,
                error = if (medics.isSuccessful) null else RuntimeException("NO ENCONTRE LISTA DE MEDICOS"),
                medicList = medics.body() ?: emptyList()
            )
        }
    }
}