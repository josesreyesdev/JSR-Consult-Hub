package com.jsrdev.jsrconsulthub.data.local.entity

import androidx.room.TypeConverter
import com.jsrdev.jsrconsulthub.core.Specialty

class MedicConverters {
    @TypeConverter
    fun fromSpecialty(specialty: Specialty): String {
        return specialty.toString()
    }

    @TypeConverter
    fun toSpecialty(specialtyStr: String): Specialty {
        return Specialty.valueOf(specialtyStr)
    }

    @TypeConverter
    fun fromAddress(address: Address): String {
        // Convierte Address a una representación de texto
        return address.toString()
    }

    @TypeConverter
    fun toAddress(addressStr: String): Address {
        // Convierte la representación de texto de Address de nuevo a Address
        return Address.parse(addressStr)
    }
}