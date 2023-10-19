package com.jsrdev.jsrconsulthub.data.network.model

import com.squareup.moshi.Json

data class AddressPatient(
    @Json(name = "city") val city: String,
    @Json(name = "complement") val complement: String,
    @Json(name = "district") val district: String,
    @Json(name = "number") val number: String,
    @Json(name = "postalCode") val postalCode: String,
    @Json(name = "province") val province: String,
    @Json(name = "urbanization") val urbanization: String
)