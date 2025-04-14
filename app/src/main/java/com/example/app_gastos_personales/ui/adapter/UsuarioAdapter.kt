package com.example.app_gastos_personales.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.app_gastos_personales.R
import com.example.app_gastos_personales.model.Usuario

class UsuarioAdapter(private val dataSet: List<Usuario>) :
    RecyclerView.Adapter<UsuarioAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNombre: TextView = view.findViewById(R.id.textViewNombre)
        val textViewEmail: TextView = view.findViewById(R.id.textViewEmail)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_usuario, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val usuario = dataSet[position]
        viewHolder.textViewNombre.text = usuario.nombre
        viewHolder.textViewEmail.text = usuario.email

    }

    override fun getItemCount() = dataSet.size
}