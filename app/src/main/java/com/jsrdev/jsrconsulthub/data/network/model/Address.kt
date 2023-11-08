package com.jsrdev.jsrconsulthub.data.network.model

import com.squareup.moshi.Json

data class Address(
    @Json(name = "street") val street: String,
    @Json(name = "district") val district: String,
    @Json(name = "city") val city: String,
    @Json(name = "number") val number: Int,
    @Json(name = "complement") val complement: String
)