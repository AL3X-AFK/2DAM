package com.example.test

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var btnAccion = findViewById<AppCompatButton>(R.id.btnAccion)
        var editText = findViewById<AppCompatEditText>(R.id.texto)
        var labelResultado = findViewById<TextView>(R.id.resultado)
        btnAccion.setOnClickListener {
            Log.i("consola", editText.text.toString())
            labelResultado.setText(editText.text.toString())
            editText.setText("")

        }


    }
}