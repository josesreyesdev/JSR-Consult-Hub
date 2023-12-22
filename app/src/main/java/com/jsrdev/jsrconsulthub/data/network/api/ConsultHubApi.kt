package com.jsrdev.jsrconsulthub.data.network.api

import com.jsrdev.jsrconsulthub.core.Constants
import com.jsrdev.jsrconsulthub.core.Constants.BASE_URL_CONSULT_HUB
import com.jsrdev.jsrconsulthub.core.Constants.BASE_URL_POSTAL_CODE
import com.jsrdev.jsrconsulthub.data.network.services.MedicService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val httpClient = OkHttpClient.Builder().apply {
    // Agrega un interceptor para incluir el token de autorización en todas las solicitudes
    addInterceptor(Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${Constants.TOKEN_CONSULT_HUB}")
            .build()
        chain.proceed(request)
    })
}

private val retrofit: (String) -> Retrofit = { url: String ->
    Retrofit.Builder()
        .baseUrl(url)
        .client(httpClient.build())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

// Module
object ConsultHubApi {

    private fun <T> retrofitService( retrofit: Retrofit, serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    val retrofitMedicService: MedicService by lazy {
        retrofitService(retrofit(BASE_URL_CONSULT_HUB), MedicService::class.java)
    }
    val otherService = retrofitService(retrofit(BASE_URL_POSTAL_CODE), MedicService::class.java)
}
