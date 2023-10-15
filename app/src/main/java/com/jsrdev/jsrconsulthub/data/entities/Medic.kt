package com.jsrdev.jsrconsulthub.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jsrdev.jsrconsulthub.data.utils.Specialty

@Entity(tableName = "medics")
data class Medic(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "document") val document: String,
    @ColumnInfo(name = "specialty") val specialty: Specialty,
    @ColumnInfo(name = "address") val address: Address,
    @ColumnInfo(name = "active") val active: Boolean = true
)