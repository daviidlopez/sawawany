package com.example.proyecto_ppg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity3 : AppCompatActivity() {
    private lateinit var personaje : Personaje
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        personaje = intent.getParcelableExtra<Personaje>("personaje")!!
    }
}