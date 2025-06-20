package com.example.parcial_2_moviles

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial_2_moviles.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity(), NavegacionPantallas {

    private lateinit var binding: ActivityRegistroBinding
    private val viewModel: PeliculaViewModel by viewModels()

    private fun validarAnio(input: String): Int? {
        val anio = input.toIntOrNull() ?: return null
        if (anio !in 1900..2025) return null
        return anio
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar opciones del Spinner (Enum)
        val generos = Genero.values().map { it.name.capitalize() }
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, generos)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spGenero.setAdapter(spinnerAdapter)

        binding.btnRegistrar.setOnClickListener {
            val titulo = binding.etTitulo.text.toString().trim()
            val anioStr = binding.etAnio.text.toString().trim()
            val resena = binding.etResenia.text.toString().trim()
            val ranking = binding.ratingBar.rating.toInt()
            val generoSeleccionado = binding.spGenero.text.toString().trim()


            if (titulo.isEmpty()) {
                Toast.makeText(this, "El título no puede estar vacío", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val anio = validarAnio(anioStr)
            if (anio == null) {
                Toast.makeText(this, "El año debe estar entre 1900 y 2025", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val genero = Genero.values().find { it.name.equals(generoSeleccionado, ignoreCase = true) }
            if (genero == null) {
                Toast.makeText(this, "Por favor, seleccioná un género válido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Creamos la nueva película
            val nuevaPelicula = Pelicula(
                id = 0,
                titulo = titulo,
                anio = anio,
                resena = resena,
                genero = genero,
                ranking = ranking
            )

            // Agregamos la película a la lista global (en memoria)
            val app = application as PeliculaApp
            app.peliculas.add(nuevaPelicula)

            // Ir al listado sin pasar la película por Intent
            val intent = Intent(this, ListadoActivity::class.java)
            startActivity(intent)

            }
        binding.btnVolverAlMenu.setOnClickListener {
            goTo(this, MainActivity::class.java)
        }

        binding.btnVerListado.setOnClickListener {
            goTo(this, ListadoActivity::class.java)
        }
    }
}