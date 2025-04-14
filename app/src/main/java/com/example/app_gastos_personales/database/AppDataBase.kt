package com.example.app_gastos_personales.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.app_gastos_personales.database.TransaccionDao
import com.example.app_gastos_personales.model.Transaccion

@Database(entities = [Transaccion::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun transaccionDao(): TransaccionDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database" // Nombre de tu base de datos
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}