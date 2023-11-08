package com.jsrdev.jsrconsulthub.data.network.model.auth

import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "jwtToken") val token: String
)
