package com.example.parcial_2_moviles

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.parcial_2_moviles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavegacionPantallas {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnIrARegistro.setOnClickListener {
            goTo(this, RegistroActivity::class.java)
        }

        binding.btnIrAListado.setOnClickListener {
            goTo(this, ListadoActivity::class.java)
        }

    }
}