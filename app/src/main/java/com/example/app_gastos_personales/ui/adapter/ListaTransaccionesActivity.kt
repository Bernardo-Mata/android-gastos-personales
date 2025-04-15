package com.example.app_gastos_personales

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_gastos_personales.R.*
import com.example.app_gastos_personales.database.AppDataBase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaTransaccionesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TransaccionAdapter
    private lateinit var db: AppDataBase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_lista_transacciones)

        recyclerView = findViewById(id.recyclerViewTransacciones)
        recyclerView.layoutManager = LinearLayoutManager(this) // O GridLayoutManager si prefieres
        adapter = TransaccionAdapter(emptyList()) // Inicialmente, la lista está vacía
        recyclerView.adapter = adapter

        db = AppDataBase.getDatabase(this)

        val fabAgregar = findViewById<FloatingActionButton>(id.fabAgregarTransaccion)
        fabAgregar.setOnClickListener {
            val intent = Intent(this, AgregarTransaccionActivity::class.java)
            startActivity(intent)
        }

        obtenerTransacciones()
    }

    private fun obtenerTransacciones() {
        lifecycleScope.launch {
            db.transaccionDao().getAllTransacciones().collectLatest { transacciones ->
                adapter.actualizarTransacciones(transacciones)
            }
        }
    }
}