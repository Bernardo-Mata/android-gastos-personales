package com.example.app_gastos_personales.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app_gastos_personales.model.Usuario

@Database(entities = [UsuarioEntity::class], version = 1, exportSchema = false)
public abstract class UsuarioDataBase : RoomDatabase(){
    abstract fun UsuarioDao(): UsuarioDao;

    companion object {
        @Volatile
        private var Instance: UsuarioDataBase? = null;
        fun getDatabase(context: Context): UsuarioDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, UsuarioDataBase::class.java, "usuario_database")
                    .fallbackToDestructiveMigration()
                    .build().also { Instance = it }
            }
        }

    }
}