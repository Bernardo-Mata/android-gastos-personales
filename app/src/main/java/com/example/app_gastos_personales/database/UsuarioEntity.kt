package com.example.app_gastos_personales.database
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "usuario")
data class UsuarioEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val email: String,
    val password: String
)