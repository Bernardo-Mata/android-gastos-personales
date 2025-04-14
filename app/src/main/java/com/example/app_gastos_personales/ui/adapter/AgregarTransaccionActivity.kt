package com.example.app_gastos_personales

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.launch
import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.lifecycleScope
import com.example.app_gastos_personales.R
import com.example.app_gastos_personales.database.AppDataBase
import com.example.app_gastos_personales.model.Transaccion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class AgregarTransaccionActivity : AppCompatActivity() {

    private lateinit var editTextTitulo: EditText
    private lateinit var editTextDescripcion: EditText
    private lateinit var editTextMonto: EditText
    private lateinit var buttonFecha: Button
    private lateinit var textViewFechaSeleccionada: TextView
    private lateinit var spinnerCategoria: Spinner
    private lateinit var buttonGuardar: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_transaccion)

        editTextTitulo = findViewById(R.id.editTextTitulo)
        editTextDescripcion = findViewById(R.id.editTextDescripcion )
        editTextMonto = findViewById(R.id.editTextMonto)
        buttonFecha = findViewById(R.id.buttonFecha)
        textViewFechaSeleccionada = findViewById(R.id.textViewFechaSeleccionada)
        spinnerCategoria = findViewById(R.id.spinnerCategoria)
        buttonGuardar = findViewById(R.id.buttonGuardar)

        // Configurar el Spinner de categorías (reemplaza con tus categorías reales)
        val categorias = listOf("Comida", "Transporte", "Entretenimiento", "Otros")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categorias)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCategoria.adapter = adapter

        // Configurar el DatePickerDialog
        buttonFecha.setOnClickListener {
            mostrarDatePicker()
        }

        // Configurar el botón Guardar
        buttonGuardar.setOnClickListener {
            guardarTransaccion()
        }
    }

    private fun mostrarDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, yearSeleccionado, monthSeleccionado, dayOfMonthSeleccionado ->
                val calendarSeleccionado = Calendar.getInstance()
                calendarSeleccionado.set(yearSeleccionado, monthSeleccionado, dayOfMonthSeleccionado)
                fechaSeleccionada = calendarSeleccionado.time

            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }



    private fun guardarTransaccion() {
        val titulo = editTextTitulo.text.toString().trim()
        val descripcion = editTextDescripcion.text.toString().trim()
        val montoString = editTextMonto.text.toString().trim()


        if (titulo.isEmpty() || descripcion.isEmpty() || montoString.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        val monto = try {
            montoString.toDouble()
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Monto inválido", Toast.LENGTH_SHORT).show()
            return
        }

        val nuevaTransaccion = Transaccion(

            descripcion = descripcion,
            monto = monto,

        )

        // guardar la transacción en la base de datos o sistema de almacenamiento

        Toast.makeText(this, "Transacción guardada: $nuevaTransaccion", Toast.LENGTH_SHORT).show()

        // Opcional: Limpiar los campos después de guardar
        limpiarCampos()
    }

    private fun limpiarCampos() {
        editTextTitulo
    }

    private var fechaSeleccionada: Date? = null
    private lateinit var db: AppDataBase



    // ... (funciones mostrarDatePicker y actualizarTextoFecha como antes)


}