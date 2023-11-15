package com.jsrdev.jsrconsulthub.data.network.api

import com.jsrdev.jsrconsulthub.core.Constants.BASE_URL_CONSULT_HUB
import com.jsrdev.jsrconsulthub.core.Constants.BASE_URL_POSTAL_CODE
import com.jsrdev.jsrconsulthub.data.network.services.MedicService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit: (String) -> Retrofit = { url: String ->
    Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(url)
        .build()
}

object ConsultHubApi {

    private fun <T> retrofitService( retrofit: Retrofit, serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    val retrofitMedicService: MedicService by lazy {
        retrofitService(retrofit(BASE_URL_CONSULT_HUB), MedicService::class.java)
    }
    val otherService = retrofitService(retrofit(BASE_URL_POSTAL_CODE), MedicService::class.java)
}