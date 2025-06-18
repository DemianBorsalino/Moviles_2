package com.example.parcial_2_moviles

import androidx.lifecycle.ViewModel

class PeliculaViewModel : ViewModel() {
    private val listaPeliculas = mutableListOf<Pelicula>()
    private var contadorId = 1

    val peliculas: List<Pelicula>
        get() = listaPeliculas

    fun agregarPelicula(titulo: String, año: Int, reseña: String, genero: Genero) {
        val nuevaPelicula = Pelicula(
            id = contadorId++,
            titulo = titulo,
            añoDeEstreno = año,
            reseña = reseña,
            genero = genero
        )
        listaPeliculas.add(nuevaPelicula)
    }
}