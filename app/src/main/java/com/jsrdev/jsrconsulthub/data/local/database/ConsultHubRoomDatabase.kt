package com.jsrdev.jsrconsulthub.data.local.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jsrdev.jsrconsulthub.data.local.dao.MedicDao

/*@Database(
    entities = [Medic::class, Patient::class, Consult::class, User::class, Token::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(MedicConverters::class, ConsultConverters::class, LocalDateTimeConverter::class) */
abstract class ConsultHubRoomDatabase : RoomDatabase() {

    abstract fun medicDao(): MedicDao
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
                    //.createFromAsset("database/consult_hub.db")// Si hay datos prepropagados
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}