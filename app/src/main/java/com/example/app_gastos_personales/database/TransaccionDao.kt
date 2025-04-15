package com.example.app_gastos_personales.database

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.app_gastos_personales.model.Transaccion
import kotlinx.coroutines.flow.Flow

@Dao
interface TransaccionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(transaccion: com.example.app_gastos_personales.model.Transaccion)


    @Query("SELECT * FROM transacciones")
    fun getAllTransacciones(): Flow<List<Transaccion>>

    @Update
    suspend fun update(transaccion: Transaccion)

    @Query("SELECT * FROM transacciones WHERE id = :id")
    suspend fun getTransaccionById(id: Int): Transaccion?

    @Query("DELETE FROM transacciones WHERE id = :id")
    suspend fun deleteTransaccionById(id: Int)



}