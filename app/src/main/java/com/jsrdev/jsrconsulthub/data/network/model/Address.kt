package com.jsrdev.jsrconsulthub.data.network.model

import com.squareup.moshi.Json

data class Address(
    @Json(name = "city") val city: String,
    @Json(name = "complement") val complement: String,
    @Json(name = "district") val district: String,
    @Json(name = "number") val number: String,
    @Json(name = "street") val street: String
)