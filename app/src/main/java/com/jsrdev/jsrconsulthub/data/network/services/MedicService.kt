package com.jsrdev.jsrconsulthub.data.network.services

import com.jsrdev.jsrconsulthub.data.network.model.medic.AddMedicRequest
import com.jsrdev.jsrconsulthub.data.network.model.medic.MedicResponse
import com.jsrdev.jsrconsulthub.data.network.model.medic.UpdateMedicRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface MedicService {

    @POST("medics/register")
    suspend fun addMedic(@Body addMedicRequest: AddMedicRequest) : MedicResponse

    @GET("medics/get-active")
    suspend fun getMedics(@Query("size") size: Int = 100): Response<List<MedicResponse>>

    @GET("medics/register/{id}")
    suspend fun getMedicById(@Path("id") id: Int): Response<MedicResponse>

    @PUT("medics")
    suspend fun updateMedic(@Body updateMedic: UpdateMedicRequest) : MedicResponse

    @DELETE("medics/{id}")
    suspend fun deactiveMedic(@Path("id") id: Int)
}