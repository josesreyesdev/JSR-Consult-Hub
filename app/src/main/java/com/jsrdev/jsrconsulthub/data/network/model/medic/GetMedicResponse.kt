package com.jsrdev.jsrconsulthub.data.network.model.medic

import com.jsrdev.jsrconsulthub.core.Specialty
import com.squareup.moshi.Json

data class GetMedicResponse(
    @Json(name = "id") val id: Int? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "specialty") val specialty: Specialty,
    @Json(name = "document") val document: String? = null,
    @Json(name = "email") val email: String? = null
)
