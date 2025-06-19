package com.example.parcial_2_moviles

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_2_moviles.databinding.ActivityListadoBinding

class ListadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoBinding
    private val viewModel: PeliculaViewModel by viewModels()
    private lateinit var adapter: PeliculaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PeliculaAdapter(emptyList())
        binding.rvPeliculas.layoutManager = LinearLayoutManager(this)
        binding.rvPeliculas.adapter = adapter

        // Observar cambios en la lista de películas para actualizar el RecyclerView
        viewModel.peliculas.observe(this) { listaPeliculas ->
            adapter.actualizarLista(listaPeliculas)
        }
    }
}