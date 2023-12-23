package com.jsrdev.jsrconsulthub.data.local.entity

import androidx.room.TypeConverter
import com.jsrdev.jsrconsulthub.core.CancellationReason

class ConsultConverters {
    @TypeConverter
    fun fromCancellationReason(cancellationReason: CancellationReason): String {
        return cancellationReason.toString()
    }

    @TypeConverter
    fun toCancellationReason(concellationReasonStr: String): CancellationReason {
        return CancellationReason.valueOf(concellationReasonStr)
    }

    //Medic
    @TypeConverter
    fun fromMedic(medic: Medic): Int? {
        return medic.id
    }

    /*
    @TypeConverter
    fun toMedic(medicId: Int): Medic {
        // Debes implementar una forma de obtener el objeto Medic a partir de su ID.
        // Esto puede requerir una consulta a tu base de datos o una fuente de datos.
        // Aquí, estamos asumiendo que existe una función para obtener el objeto Medic por su ID.
        return getMedicById(medicId)
    } */

    // Patient
    @TypeConverter
    fun fromPatient(patient: Patient): Int {
        return patient.id
    }
/*
    @TypeConverter
    fun toPatient(patientId: Int): Patient {
        // Implementa una función para obtener el objeto Patient por su ID.
        return getPatientById(patientId)
    } */
}