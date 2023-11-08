package com.jsrdev.jsrconsulthub.data.network.model.medic

import com.jsrdev.jsrconsulthub.core.Specialty
import com.squareup.moshi.Json

data class GetMedicResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "specialty") val specialty: Specialty,
    @Json(name = "document") val document: String,
    @Json(name = "email") val email: String
)
