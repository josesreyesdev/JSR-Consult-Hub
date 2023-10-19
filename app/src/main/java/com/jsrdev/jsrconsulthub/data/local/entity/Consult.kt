package com.jsrdev.jsrconsulthub.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jsrdev.jsrconsulthub.core.CancellationReason
import java.time.LocalDateTime

@Entity(tableName = "consults")
data class Consult(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "id_medic") val medic: Medic,
    @ColumnInfo(name = "id_patient") val patient: Patient,
    @ColumnInfo(name = "datetime") val date: LocalDateTime,
    @ColumnInfo(name = "cancellation_reason") val cancellationReason: CancellationReason?
)