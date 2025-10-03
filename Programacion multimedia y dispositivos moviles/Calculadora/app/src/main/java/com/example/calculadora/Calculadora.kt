package com.example.calculadora

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Calculadora : AppCompatActivity() {

    var num1 = 0.0
    var num2 = 0.0
    var operacionActual = ""

    lateinit var tvTemp: TextView
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculadora)


        tvTemp = findViewById(R.id.tvTemp)
        tvResult = findViewById(R.id.tvResult)

        var btnReset = findViewById<Button>(R.id.btnC)
        var btnResult = findViewById<Button>(R.id.btnResult)

        var botonesNumeros = listOf(R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
            R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9, R.id.btnPunto)

        var operadores = listOf(R.id.btnPlus, R.id.btnRest, R.id.btnMult, R.id.btnDiv)



        //Pulsar numeros
        for (id in botonesNumeros){
            findViewById<Button>(id).setOnClickListener { boton ->
                val b = boton as Button
                tvResult.append(b.text)
            }
        }

        //Pulsar operadores
        for (id in operadores){
            findViewById<Button>(id).setOnClickListener { boton->
                val b = boton as Button
                operacionActual = b.text.toString()
                num1 = tvResult.text.toString().toDouble()

                tvTemp.text = num1.toString() + " " + operacionActual

                tvResult.text = ""
            }
        }

        //Pulsar igual
        btnResult.setOnClickListener {
            num2 = tvResult.text.toString().toDouble()
            val resultado = when (operacionActual){
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2
                else -> 0.0
            }
            tvTemp.text = tvTemp.text.toString() +" "+ num2.toString()
            tvResult.text = resultado.toString()
        }

        //Boton de reset
        btnReset.setOnClickListener {
            tvTemp.text= ""
            tvResult.text = ""
        }

    }
}