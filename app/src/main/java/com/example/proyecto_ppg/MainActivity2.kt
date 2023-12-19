package com.example.proyecto_ppg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var personaje : Personaje
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        personaje = intent.getParcelableExtra<Personaje>("personaje")!!
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = personaje.toString()
        this.botonListener1()
        this.botonListener2()
    }

    private fun botonListener1() {
        findViewById<Button>(R.id.button1).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun botonListener2() {
        findViewById<Button>(R.id.button2).setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("personaje", personaje)
            startActivity(intent)
        }
    }
}