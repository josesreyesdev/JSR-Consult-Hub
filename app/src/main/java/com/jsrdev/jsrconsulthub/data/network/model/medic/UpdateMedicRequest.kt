package com.jsrdev.jsrconsulthub.data.network.model.medic

import com.jsrdev.jsrconsulthub.data.network.model.Address

data class UpdateMedicRequest(
    val id: Int,
    val name: String?,
    val document: String?,
    val address: Address?
)
