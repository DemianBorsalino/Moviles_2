package com.example.parcial_2_moviles

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial_2_moviles.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private val viewModel: PeliculaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar opciones del Spinner (Enum)
        val generos = Genero.values().map { it.name.capitalize() }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spGenero.adapter = adapter

        binding.btnRegistrar.setOnClickListener {
            val titulo = binding.etTitulo.text.toString().trim()
            val anioStr = binding.etAnio.text.toString().trim()
            val resena = binding.etResena.text.toString().trim()
            val genero = Genero.values()[binding.spGenero.selectedItemPosition]

            if (titulo.isEmpty()) {
                Toast.makeText(this, "El título no puede estar vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val anio = anioStr.toIntOrNull()
            if (anio == null) {
                Toast.makeText(this, "Año inválido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear objeto Pelicula y mandarlo por Intent
            val pelicula = Pelicula(titulo, anio, resena, genero)

            val intent = Intent(this, ListadoActivity::class.java)
            intent.putExtra("pelicula", pelicula)
            startActivity(intent)
        }
    }
}