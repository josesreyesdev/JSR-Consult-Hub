package com.jsrdev.jsrconsulthub

import android.app.Application
import com.jsrdev.jsrconsulthub.data.local.database.ConsultHubRoomDatabase

class ConsultHubApplication : Application(){
    val database: ConsultHubRoomDatabase by lazy { ConsultHubRoomDatabase.getDatabase(this) }
}