package com.example.myapplication.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R

class ResoultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resoult)

        val tvResoult = findViewById<TextView>(R.id.tvResoult)
        val name : String? = intent.extras?.getString("Extra_name")

        tvResoult.text = "¡Hola ${name}!"
    }
}