package com.jsrdev.jsrconsulthub.service.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jsrdev.jsrconsulthub.data.entities.*

@Database(
    entities = [Medic::class, Patient::class, Consult::class, User::class, Token::class],
    version = 1,
    exportSchema = false
)
abstract class ConsultHubRoomDatabase : RoomDatabase() {

    //abstract fun medicDao: MedicDao
    //abstract fun patientDao: Patient
    //abstract fun consultDao: ConsultDao
    //abstract fun userDao: TokenDao

    companion object {
        @Volatile
        private var INSTANCE: ConsultHubRoomDatabase? = null

        fun getDatabase(context: Context): ConsultHubRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ConsultHubRoomDatabase::class.java,
                    context.packageName.toString()
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}