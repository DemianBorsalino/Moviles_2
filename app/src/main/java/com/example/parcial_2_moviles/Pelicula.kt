package com.example.parcial_2_moviles

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Pelicula(
    val id: Int,
    val titulo: String,
    val anoDeEstreno: Int,
    val resena: String,
    val genero: Genero
) : Parcelable