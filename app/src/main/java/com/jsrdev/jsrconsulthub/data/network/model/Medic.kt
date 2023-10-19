package com.jsrdev.jsrconsulthub.data.network.model

import com.squareup.moshi.Json

data class Medic(
    @Json(name = "address") val address: Address,
    @Json(name = "document") val document: String,
    @Json(name = "email") val email: String,
    @Json(name = "name") val name: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "specialty") val specialty: String
)