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

//Viewmodel es aquel nos deja ingresar los objetos dentro de la app. Creandolo mediante esta función
//con la información agregada en pentalla. El contador está hecho para que tengan un ID, que sería
//lo mejor para una base de datos original en sql o lo que sea