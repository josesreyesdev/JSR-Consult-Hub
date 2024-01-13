package com.jsrdev.jsrconsulthub.data.mocks

import com.jsrdev.jsrconsulthub.core.Specialty
import com.jsrdev.jsrconsulthub.data.network.model.medic.AddMedicRequest
import com.jsrdev.jsrconsulthub.data.network.model.medic.GetMedicResponse
import com.jsrdev.jsrconsulthub.data.network.model.medic.MedicResponse
import com.jsrdev.jsrconsulthub.data.network.model.medic.UpdateMedicRequest
import com.jsrdev.jsrconsulthub.data.network.services.MedicService
import retrofit2.Response

class MockMedicRepository : MedicService {
    override suspend fun addMedic(addMedicRequest: AddMedicRequest): MedicResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getMedics(token: String, size: Int): Response<List<GetMedicResponse>> {
        return Response.success(
            listOf(
                GetMedicResponse(1, "José S R", Specialty.CARDIOLOGIA, "31233", "sanjose@example.com"),
                GetMedicResponse(2, "Marcos Enrique", Specialty.PEDIATRIA, "41241", "sanmarcos@example.com"),
                GetMedicResponse(3, "Piter Mckalister", Specialty.ORTOPEDIA, "624432", "sanpiter@example.com"),
                GetMedicResponse(3, "Rosa Maria", Specialty.GINECOLOGIA, "89890", "santamaria@example.com"),
                GetMedicResponse(3, "Marco Aurelio Marco Aurelio", Specialty.ODONTOLOGIA, "88080", "santaines@example.com")
            )
        )
    }

    override suspend fun getMedicById(id: Int): Response<MedicResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun updateMedic(updateMedic: UpdateMedicRequest): MedicResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deactivateMedic(id: Int) {
        TODO("Not yet implemented")
    }

}
