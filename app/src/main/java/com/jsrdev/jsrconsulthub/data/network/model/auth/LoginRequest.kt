package com.jsrdev.jsrconsulthub.data.network.model.auth

import com.squareup.moshi.Json

data class LoginRequest(
    @Json(name = "login") val username: String,
    @Json(name = "clave") val password: String
)
