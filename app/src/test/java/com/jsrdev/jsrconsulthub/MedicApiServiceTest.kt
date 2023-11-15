package com.jsrdev.jsrconsulthub

import com.jsrdev.jsrconsulthub.data.network.services.MedicService
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MedicApiServiceTest : BaseTest() {

    private lateinit var medicService: MedicService

    @Before // antes de cada test
    fun setup() {
        val url: HttpUrl = mockWebServer.url("/") // url a interceptar

        medicService = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                )
            )
            .build()
            .create(MedicService::class.java)
    }

    @Test
    fun medicApiService() {

        enqueue("get_medics.json")

        runBlocking {
            val medicApiResponse = medicService.getMedics( size = 10)

            // asegurar que la respuesta no sea null
            assertNotNull(medicApiResponse)

            // asegurar que la lista no esté vacia
            medicApiResponse.body()?.isNotEmpty()?.let { assertTrue("The list was empty", it) }

            // verificar que algunos datos sean correctas
            assertEquals("The IDs did not match", 5, medicApiResponse.body()?.get(4)?.id)
        }
    }
}