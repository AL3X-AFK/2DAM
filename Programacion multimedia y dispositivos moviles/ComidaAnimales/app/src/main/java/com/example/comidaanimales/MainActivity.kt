package com.example.comidaanimales

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {

    lateinit var cvDog: CardView
    lateinit var cvCat: CardView
    lateinit var tvWeight: TextView
    lateinit var rsWeight: RangeSlider
    lateinit var tvAge: TextView
    lateinit var fabDecrementAge: FloatingActionButton
    lateinit var fabAddAge: FloatingActionButton

    var animalSelected: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponents()
        initiListeners()

    }

    private fun initComponents(){
        cvDog = findViewById<CardView>(R.id.cvDog)
        cvCat = findViewById<CardView>(R.id.cvCat)
        tvWeight = findViewById<TextView>(R.id.tvWeight)
        rsWeight = findViewById<RangeSlider>(R.id.rsWeight)
        tvAge = findViewById(R.id.tvAge)
        fabAddAge = findViewById(R.id.fabAddAge)
        fabDecrementAge = findViewById(R.id.fabDecrementAge)
    }

    private fun initiListeners(){
        cvDog.setOnClickListener {
            animalSelected = "Dog"
            var colorSeleccion: Int = ContextCompat.getColor(this, R.color.app_comida_mascotas_cardview_selected)
            cvDog.setBackgroundColor(colorSeleccion)

            var colorNoSeleccion: Int = ContextCompat.getColor(this, R.color.app_comida_mascotas_cardview)
            cvCat.setBackgroundColor(colorNoSeleccion)
        }
        cvCat.setOnClickListener {
            animalSelected = "Cat"
            var colorSeleccion: Int = ContextCompat.getColor(this, R.color.app_comida_mascotas_cardview_selected)
            cvCat.setBackgroundColor(colorSeleccion)

            var colorNoSeleccion: Int = ContextCompat.getColor(this, R.color.app_comida_mascotas_cardview)
            cvDog.setBackgroundColor(colorNoSeleccion)
        }

        rsWeight.addOnChangeListener {_, value, _->

            var resultWeight = value.toInt()
            tvWeight.text = "$resultWeight Kg"
        }
    }

    private fun calculateWeightFood(){

    }


}