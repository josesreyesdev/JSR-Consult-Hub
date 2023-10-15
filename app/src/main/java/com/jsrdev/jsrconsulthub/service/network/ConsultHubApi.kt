package com.jsrdev.jsrconsulthub.service.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL_CONSULT_HUB = "https://6c85-189-217-51-223.ngrok-free.app/"
private const val BASE_URL_POSTAL_CODE = "https://api.copomex.com/query/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

fun provideRetrofit(url: String): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(url)
        .build()
}

object ConsultHubApi {

    private val retrofitConsultHub: Retrofit = provideRetrofit(BASE_URL_CONSULT_HUB)
    private val retrofitPostalCode: Retrofit = provideRetrofit(BASE_URL_POSTAL_CODE)

    private fun <T> createService( retrofit: Retrofit, serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    /*val retrofitService: ConsultHubApiService by lazy {
        createService( retrofitConsultHub, ConsultHubApiService::class.java)
    }

    val otherService = JsrApi.createService( retrofitPostalCode, OtherService::class.java) */
}