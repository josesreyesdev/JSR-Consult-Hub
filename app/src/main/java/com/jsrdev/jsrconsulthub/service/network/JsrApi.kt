package com.jsrdev.jsrconsulthub.service.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://6c85-189-217-51-223.ngrok-free.app/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()
}
object JsrApi {

    private val retrofit: Retrofit = provideRetrofit()

    private fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    /*val retrofitService: ConsultHubApiService by lazy {
        createService(ConsultHubApiService::class.java)
    }

    val otroServicio = JsrApi.createService(OtroServicio::class.java) */
}