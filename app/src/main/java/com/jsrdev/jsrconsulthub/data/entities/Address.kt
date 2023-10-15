package com.jsrdev.jsrconsulthub.data.entities

import androidx.room.ColumnInfo

data class Address(
    @ColumnInfo(name = "street") val street: String,
    @ColumnInfo(name = "district") val district: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "number") val number: Int,
    @ColumnInfo(name = "complement") val complement: String,
    @ColumnInfo(name = "urbanization") val urbanization: String,
    @ColumnInfo(name = "postal_code") val postalCode: String,
    @ColumnInfo(name = "province") val province: Int
)
