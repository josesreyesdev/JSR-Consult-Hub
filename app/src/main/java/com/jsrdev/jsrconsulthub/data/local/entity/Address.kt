package com.jsrdev.jsrconsulthub.data.local.entity

import androidx.room.ColumnInfo

data class Address(
    @ColumnInfo(name = "street") val street: String? = null,
    @ColumnInfo(name = "district") val district: String? = null,
    @ColumnInfo(name = "city") val city: String? = null,
    @ColumnInfo(name = "number") val number: Int? = null,
    @ColumnInfo(name = "complement") val complement: String? = null,
    @ColumnInfo(name = "urbanization") val urbanization: String? = null,
    @ColumnInfo(name = "postal_code") val postalCode: String? = null,
    @ColumnInfo(name = "province") val province: Int? = null
) {
    override fun toString(): String {
        return "$street, $district, $city, $number, $complement, $urbanization, $postalCode, $province"
    }

    companion object {
        fun parse(addressStr: String): Address {
            val parts = addressStr.split(", ")
            if (parts.size != 8) {
                throw IllegalArgumentException("La cadena de dirección no es válida: $addressStr")
            }
            val street = parts[0]
            val district = parts[1]
            val city = parts[2]
            val number = parts[3].toInt()
            val complement = parts[4]
            val urbanization = parts[5]
            val postalCode = parts[6]
            val province = parts[7].toInt()

            return Address(street, district, city, number, complement, urbanization, postalCode, province)
        }
    }
}
