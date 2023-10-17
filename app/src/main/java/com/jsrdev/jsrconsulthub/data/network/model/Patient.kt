package com.jsrdev.jsrconsulthub.data.network.model

import com.squareup.moshi.Json

data class Patient(
    @Json(name = "address") val address: AddressPatient,
    @Json(name = "email") val email: String,
    @Json(name = "identityDocument") val identityDocument: String,
    @Json(name = "name") val name: String,
    @Json(name = "phone") val phone: String
)