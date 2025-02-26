package com.example.app_gastos_personales.model

import java.util.Date

data class Transaccion(

    val id: Int,
    val monto: Double,
    val descripcion: String,
    val fecha: String,
    val categoria: String
)
