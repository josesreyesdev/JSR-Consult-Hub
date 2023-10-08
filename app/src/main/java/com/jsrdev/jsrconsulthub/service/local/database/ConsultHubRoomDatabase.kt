package com.jsrdev.jsrconsulthub.service.local.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database( entities = [], version = 1, exportSchema = false)
abstract class ConsultHubRoomDatabase : RoomDatabase() {

}