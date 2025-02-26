package com.example.app_gastos_personales.database

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
@Dao
interface TransaccionDao {
    @Insert
    suspend fun insertar(transaccion: TransaccionEntity)

    @Query("SELECT * FROM transacciones")
    suspend fun obtenerTodas(): List<TransaccionEntity>
}