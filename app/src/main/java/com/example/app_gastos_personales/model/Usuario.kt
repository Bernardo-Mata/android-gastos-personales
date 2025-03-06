package com.example.app_gastos_personales.model


import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Usuario(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val email: String,
    val password: String
)