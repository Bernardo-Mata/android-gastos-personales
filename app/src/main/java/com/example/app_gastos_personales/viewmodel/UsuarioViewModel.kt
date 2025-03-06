package com.example.app_gastos_personales.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_gastos_personales.database.UsuarioDao
import com.example.app_gastos_personales.database.UsuarioEntity
import kotlinx.coroutines.launch

class UsuarioViewModel(private val dao: UsuarioDao): ViewModel() {
    val usuarios = dao.getAllItems()

    fun agregarUsuarios(usuarios: UsuarioEntity){
        viewModelScope.launch {
            dao.insert(usuarios)
        }

    }
}