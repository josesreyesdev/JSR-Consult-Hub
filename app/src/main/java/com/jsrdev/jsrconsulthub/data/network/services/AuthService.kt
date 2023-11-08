package com.jsrdev.jsrconsulthub.data.network.services

import com.jsrdev.jsrconsulthub.data.network.model.auth.LoginRequest
import com.jsrdev.jsrconsulthub.data.network.model.auth.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}