package com.example.parcial_2_moviles

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_2_moviles.databinding.ActivityListadoBinding
import androidx.appcompat.app.AlertDialog


class ListadoActivity : AppCompatActivity(), NavegacionPantallas {

    private lateinit var binding: ActivityListadoBinding
    private val viewModel: PeliculaViewModel by viewModels()
    private lateinit var adapter: PeliculaAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Volver a cargar las películas desde memoria
        val app = application as PeliculaApp
        viewModel.setLista(app.peliculas)

        adapter = PeliculaAdapter(emptyList()) { peliculaAEliminar ->
            confirmarEliminacion(peliculaAEliminar)
        }

        binding.rvPeliculas.layoutManager = LinearLayoutManager(this)
        binding.rvPeliculas.adapter = adapter

        viewModel.peliculas.observe(this) { listaPeliculas ->
            adapter.actualizarLista(listaPeliculas)
        }

        binding.btnVolverAlMenu.setOnClickListener {
            goTo(this, MainActivity::class.java)
        }

        binding.btnIrARegistro.setOnClickListener {
            goTo(this, RegistroActivity::class.java)
        }
    }

    private fun confirmarEliminacion(pelicula: Pelicula) {
        AlertDialog.Builder(this)
            .setTitle("Confirmar eliminación")
            .setMessage("¿Estás seguro de que querés eliminar \"${pelicula.titulo}\"?")
            .setPositiveButton("Sí, eliminar") { dialog, _ ->
                val app = application as PeliculaApp
                app.peliculas.remove(pelicula)
                viewModel.setLista(app.peliculas)
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }



}