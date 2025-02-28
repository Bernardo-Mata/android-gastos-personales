package com.example.app_gastos_personales.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app_gastos_personales.model.Transaccion

@Database(entities = [TransaccionEntity::class], version = 1, exportSchema = false)
public abstract class TransaccionesDataBase : RoomDatabase(){
    abstract fun TransaccionDao(): TransaccionDao;

    companion object {
        @Volatile
        private var Instance: TransaccionesDataBase? = null;
        fun getDatabase(context: Context): TransaccionesDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, TransaccionesDataBase::class.java, "transaccion_database")
                    .fallbackToDestructiveMigration()
                    .build().also { Instance = it }
            }
        }

    }
}