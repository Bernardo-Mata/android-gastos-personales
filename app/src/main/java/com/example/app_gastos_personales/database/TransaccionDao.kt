package com.example.app_gastos_personales.database

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy
import com.example.app_gastos_personales.model.Transaccion
import kotlinx.coroutines.flow.Flow

@Dao
interface TransaccionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(transaccion: TransaccionEntity)


    @Query("SELECT * FROM transacciones")
    fun getAllItems(): Flow<List<Transaccion>>
}