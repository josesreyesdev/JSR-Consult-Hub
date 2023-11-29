package com.jsrdev.jsrconsulthub.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.jsrdev.jsrconsulthub.data.local.entity.Medic
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicDao {

    @Query("SELECT * FROM medics ORDER BY name ASC")
    fun getAllMedics(): Flow<List<Medic>>

}