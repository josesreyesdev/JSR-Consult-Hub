package com.jsrdev.jsrconsulthub.data.network.model.medic

import com.jsrdev.jsrconsulthub.data.network.model.Address
import com.squareup.moshi.Json

data class MedicResponse(
    @Json(name= "id") val id: Int,
    @Json(name = "name") val name: String,
    @Json(name = "email") val email: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "specialty") val specialty: String,
    @Json(name = "document") val document: String,
    @Json(name = "address") val address: Address
)