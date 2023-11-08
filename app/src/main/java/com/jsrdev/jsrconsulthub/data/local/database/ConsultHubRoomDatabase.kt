package com.jsrdev.jsrconsulthub.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jsrdev.jsrconsulthub.core.LocalDateTimeConverter
import com.jsrdev.jsrconsulthub.data.local.entity.MedicConverters
import com.jsrdev.jsrconsulthub.data.local.entity.Consult
import com.jsrdev.jsrconsulthub.data.local.entity.ConsultConverters
import com.jsrdev.jsrconsulthub.data.local.entity.Medic
import com.jsrdev.jsrconsulthub.data.local.entity.Patient
import com.jsrdev.jsrconsulthub.data.local.entity.Token
import com.jsrdev.jsrconsulthub.data.local.entity.User
/*
@Database(
    entities = [Medic::class, Patient::class, Consult::class, User::class, Token::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(MedicConverters::class, ConsultConverters::class, LocalDateTimeConverter::class) */
abstract class ConsultHubRoomDatabase : RoomDatabase() {

    //abstract fun medicDao(): MedicDao
    //abstract fun patientDao(): Patient
    //abstract fun consultDao(): ConsultDao
    //abstract fun userDao(): UserDao
    //abstract fun tokenDao(): TokenDao

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