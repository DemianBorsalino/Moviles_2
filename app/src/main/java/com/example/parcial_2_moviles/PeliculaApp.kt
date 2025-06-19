package com.example.parcial_2_moviles

import android.app.Application

class PeliculaApp : Application() {
    val peliculas = mutableListOf<Pelicula>()
}
//Importante esta clase porque guarda los datos para poder mosrtrarla en el listado.
// Sin esta clase, los datos se borran al salir de la pantalla, logrando que se borre todo
