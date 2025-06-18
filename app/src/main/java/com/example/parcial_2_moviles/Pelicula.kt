package com.example.parcial_2_moviles

enum class Genero {
    ACCION, COMEDIA, DRAMA, DOCUMENTAL, OTRO
}

data class Pelicula(
    val id: Int,
    val titulo: String,
    val añoDeEstreno: Int,
    val reseña: String,
    val genero: Genero
)