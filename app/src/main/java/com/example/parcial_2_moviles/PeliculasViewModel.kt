package com.example.parcial_2_moviles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PeliculaViewModel : ViewModel() {

    private val _peliculas = MutableLiveData<List<Pelicula>>(emptyList())
    val peliculas: LiveData<List<Pelicula>> get() = _peliculas

    private var contadorId = 1

    fun agregarPelicula(titulo: String, ano: Int, resena: String, genero: Genero) {
        val nuevaPelicula = Pelicula(
            id = contadorId++,
            titulo = titulo,
            anio = ano,
            resena = resena,
            genero = genero
        )

        val listaActual = _peliculas.value ?: emptyList()
        _peliculas.value = listaActual + nuevaPelicula
    }
}