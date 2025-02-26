package com.example.app_gastos_personales.database
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transacciones")
data class TransaccionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val monto: Double,
    val descripcion: String,
    val fecha: String,
    val categoria: String
)