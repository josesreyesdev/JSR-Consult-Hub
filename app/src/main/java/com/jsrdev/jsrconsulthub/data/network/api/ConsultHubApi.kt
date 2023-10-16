package com.jsrdev.jsrconsulthub.data.network.api

import com.jsrdev.jsrconsulthub.core.Constants.BASE_URL_CONSULT_HUB
import com.jsrdev.jsrconsulthub.core.Constants.BASE_URL_POSTAL_CODE
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

    private fun <T> retrofitService( retrofit: Retrofit, serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    /*val retrofitService: ConsultHubApiService by lazy {
        retrofitService( retrofitConsultHub, ConsultHubApiService::class.java)
    }

    val otherService = ConsultHubApi.retrofitService( retrofitPostalCode, OtherService::class.java) */
}