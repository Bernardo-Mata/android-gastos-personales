package com.example.app_gastos_personales

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_gastos_personales.model.Transaccion

class TransaccionAdapter(private var transacciones: List<Transaccion>) :
    RecyclerView.Adapter<TransaccionAdapter.TransaccionViewHolder>() {

    class TransaccionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewDescripcion: TextView = itemView.findViewById(R.id.textViewDescription)
        val textViewMonto: TextView = itemView.findViewById(R.id.textViewMonto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaccionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaccion, parent, false)
        return TransaccionViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: TransaccionViewHolder, position: Int) {
        val transaccion = transacciones[position]
        holder.textViewDescripcion.text = transaccion.descripcion
        holder.textViewMonto.text = transaccion.monto.toString() // Formatea el monto si es necesario
    }

    override fun getItemCount() = transacciones.size

    @SuppressLint("NotifyDataSetChanged")
    fun actualizarTransacciones(nuevasTransacciones: List<Transaccion>) {
        transacciones = nuevasTransacciones
        notifyDataSetChanged()
    }
}