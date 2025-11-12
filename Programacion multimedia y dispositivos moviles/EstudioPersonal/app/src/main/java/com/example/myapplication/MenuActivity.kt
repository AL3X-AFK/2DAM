package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.firstapp.FirstAppActivity
import com.example.myapplication.imc_calculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludar = findViewById<Button>(R.id.btnSaludApp)
        btnSaludar.setOnClickListener { navigateToApp(FirstAppActivity::class.java) }

        val btnImcCalculator = findViewById<Button>(R.id.btnImcCalculator)
        btnImcCalculator.setOnClickListener { navigateToApp(ImcCalculatorActivity::class.java) }
    }


    fun navigateToApp(activityClass: Class<*>){
        val intent = Intent (this, activityClass )
        startActivity(intent)
    }
}