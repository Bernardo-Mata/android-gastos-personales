package com.example.app_gastos_personales.database

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy
import com.example.app_gastos_personales.model.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(usuario: UsuarioEntity)


    @Query("SELECT * from usuario WHERE id = :id")
    fun getItem(id: Int): Flow<Usuario>

    @Query("SELECT * FROM usuario")
    fun getAllItems(): Flow<List<Usuario>>
}