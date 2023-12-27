package com.jsrdev.jsrconsulthub.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jsrdev.jsrconsulthub.core.Specialty

@Entity(tableName = "medics")
data class Medic(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "email") val email: String? = null,
    @ColumnInfo(name = "phone") val phone: String? = null,
    @ColumnInfo(name = "document") val document: String? = null,
    @ColumnInfo(name = "specialty") val specialty: Specialty,
    @ColumnInfo(name = "address") val address: Address,
    @ColumnInfo(name = "active") val active: Boolean = true
)