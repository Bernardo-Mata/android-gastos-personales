package com.example.app_gastos_personales.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_gastos_personales.database.TransaccionDao
import com.example.app_gastos_personales.database.TransaccionEntity
import kotlinx.coroutines.launch

class TransaccionViewModel(private val dao: TransaccionDao): ViewModel() {
    val transacciones = dao.getAllItems()

    fun agregarTransaccion(transaccion: TransaccionEntity){
        viewModelScope.launch {
            dao.insert(transaccion)
        }

    }
}