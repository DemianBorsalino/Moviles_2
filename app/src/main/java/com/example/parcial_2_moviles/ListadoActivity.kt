package com.example.parcial_2_moviles

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parcial_2_moviles.databinding.ActivityListadoBinding

class ListadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoBinding
    private val viewModel: PeliculaViewModel by viewModels() // nuevo ViewModel separado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar RecyclerView
        binding.rvPeliculas.layoutManager = LinearLayoutManager(this)
        binding.rvPeliculas.adapter = PeliculaAdapter(viewModel.obtenerPeliculas())
    }
}