package com.example.proyecto_ppg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var  spinnerRaza: Spinner
    private lateinit var  spinnerClase: Spinner
    private lateinit var  spinnerEstado: Spinner
    private lateinit var imgPersonaje: ImageView
    private lateinit var imgClase: ImageView

    // Strings para el constructor
    private lateinit var nombreP : String
    private lateinit var estadoP : String
    private lateinit var razaP : String
    private lateinit var claseP : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        spinnerRaza = findViewById<Spinner>(R.id.spinnerRaza)
        spinnerClase = findViewById<Spinner>(R.id.spinnerClase)
        spinnerEstado = findViewById<Spinner>(R.id.spinnerEstadoVital)
        imgPersonaje = findViewById<ImageView>(R.id.personajeImagen)
        imgClase = findViewById<ImageView>(R.id.claseImagen)


        this.botonListener()
        this.cambiarImgPersonaje()
        this.cambiarImgClase()

    }

    private fun botonListener() {
        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            nombreP = editTextNombre.text.toString()
            val personaje = Personaje(nombreP, estadoP, razaP, claseP)
            intent.putExtra("personaje",personaje)
            startActivity(intent)
        }
    }

    //Procedimiento que cambia la imagenClase segun el SpinnerClase
    private fun cambiarImgClase(){
        val adapterClase = ArrayAdapter.createFromResource(
            this, R.array.Clases,
            android.R.layout.simple_spinner_item
        )
        adapterClase.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerClase.adapter = adapterClase
        spinnerClase.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when (position) {
                    0 -> imgClase.setImageResource(R.drawable.brujo_rombo)
                    1 -> imgClase.setImageResource(R.drawable.guerrero_rombo)
                    2 -> imgClase.setImageResource(R.drawable.mago_rombo)
                }
                //Extraemos la string de la spinner en la propiedad claseP
                claseP = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    //Procedimiento que cambiar imgPersonaje segun spinnerRaza y spinnerEstado
    private fun cambiarImgPersonaje() {
        val adapterRaza = ArrayAdapter.createFromResource(
            this, R.array.Razas,
            android.R.layout.simple_spinner_item
        )
        adapterRaza.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRaza.adapter = adapterRaza

        spinnerRaza.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentRaza: AdapterView<*>?,
                view: View?,
                positionRaza: Int,
                id: Long
            ) {
                val adapterEstado = ArrayAdapter.createFromResource(
                    this@MainActivity, R.array.EstadoVital,
                    android.R.layout.simple_spinner_item
                )
                adapterEstado.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerEstado.adapter = adapterEstado

                spinnerEstado.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        // Cambiar las imágenes según las selecciones de Spinners
                        when (positionRaza to position) {
                            0 to 0 -> imgPersonaje.setImageResource(R.drawable.humano_anciano)
                            0 to 1 -> imgPersonaje.setImageResource(R.drawable.humano_adulto)
                            0 to 2 -> imgPersonaje.setImageResource(R.drawable.humano_joven)

                            1 to 0 -> imgPersonaje.setImageResource(R.drawable.elfo_anciano)
                            1 to 1 -> imgPersonaje.setImageResource(R.drawable.elfo_adulto)
                            1 to 2 -> imgPersonaje.setImageResource(R.drawable.elfo_joven)

                            2 to 0 -> imgPersonaje.setImageResource(R.drawable.enano_anciano)
                            2 to 1 -> imgPersonaje.setImageResource(R.drawable.enano_adulto)
                            2 to 2 -> imgPersonaje.setImageResource(R.drawable.enano_joven)

                            3 to 0 -> imgPersonaje.setImageResource(R.drawable.maldito_anciano)
                            3 to 1 -> imgPersonaje.setImageResource(R.drawable.maldito_adulto)
                            3 to 2 -> imgPersonaje.setImageResource(R.drawable.maldito_joven)
                        }
                        razaP = parentRaza?.getItemAtPosition(positionRaza).toString()
                        estadoP = parent?.getItemAtPosition(position).toString()
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

}