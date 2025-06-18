package com.example.parcial_2_moviles

import androidx.lifecycle.ViewModel

class PeliculaViewModel : ViewModel() {
    private val listaPeliculas = mutableListOf<Pelicula>()
    private var contadorId = 1

    val peliculas: List<Pelicula>
        get() = listaPeliculas

    fun agregarPelicula(titulo: String, ano: Int, resena: String, genero: Genero) {
        val nuevaPelicula = Pelicula(
            id = contadorId++,
            titulo = titulo,
            anoDeEstreno = ano,
            resena = resena,
            genero = genero
        )
        listaPeliculas.add(nuevaPelicula)
    }

    fun obtenerPeliculas(): List<Pelicula> {
        return peliculas
    }
}