package com.example.app_gastos_personales.model

import java.util.Date
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "transacciones")
data class Transaccion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val descripcion: String,
    val monto: Double
)
