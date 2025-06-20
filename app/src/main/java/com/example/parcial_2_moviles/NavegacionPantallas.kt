package com.example.parcial_2_moviles

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

interface NavegacionPantallas {
    fun <T : AppCompatActivity> goTo(context: Context, destino: Class<T>) {
        val intent = Intent(context, destino)
        context.startActivity(intent)

        // Solo cerramos si el context es una Activity
        if (context is AppCompatActivity) {
            context.finish()
        }
    }
}