package com.jsrdev.jsrconsulthub.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "patients")
data class Patient(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "identity_document") val document: String,
    @ColumnInfo(name = "address") val address: Address,
    @ColumnInfo(name = "active") val active: Boolean = true
)
