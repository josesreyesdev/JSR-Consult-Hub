package com.jsrdev.jsrconsulthub.data.repository

import com.jsrdev.jsrconsulthub.data.mocks.MockMedicRepository
import com.jsrdev.jsrconsulthub.data.network.services.MedicService

object MedicModule {
    fun provideRepository(): MedicService {
        return MockMedicRepository()
    }
}