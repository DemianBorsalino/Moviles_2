package com.example.parcial_2_moviles

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_2_moviles.databinding.ActivityListadoBinding

class ListadoActivity : AppCompatActivity(), NavegacionPantallas {

    private lateinit var binding: ActivityListadoBinding
    private val viewModel: PeliculaViewModel by viewModels()
    private lateinit var adapter: PeliculaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Volver a cargar las películas desde memoria
        val app = application as PeliculaApp
        viewModel.setLista(app.peliculas)

        adapter = PeliculaAdapter(emptyList()) { peliculaAEliminar ->
            app.peliculas.remove(peliculaAEliminar)
            viewModel.setLista(app.peliculas)
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

}