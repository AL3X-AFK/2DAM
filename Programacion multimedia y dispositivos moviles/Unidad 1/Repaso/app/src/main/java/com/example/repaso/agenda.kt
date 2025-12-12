package com.example.repaso

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class agenda : AppCompatActivity() {

    lateinit var btnInicio : Button

    private val contactos = mutableListOf<Contacto>(
        Contacto("Lucas", 12345678987),
        Contacto("Juan", 123456789),
        Contacto("Maria", 98765432101),
        Contacto("Julia", 12345678),
        Contacto("Andy", 45678912345)
    )

    lateinit var rvListadoContactos: RecyclerView

    lateinit var adapter: ContactosAdapter

    lateinit var btnCheck: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_agenda)

        initComponents()
        initUi()
        initListeners()
    }

    private fun initComponents(){
        rvListadoContactos = findViewById<RecyclerView>(R.id.rvListadoCOntactos)
        btnCheck = findViewById(R.id.btnCheck)
        btnInicio = findViewById(R.id.btnInicio)
    }

    private fun initUi(){
        adapter = ContactosAdapter(contactos)
        rvListadoContactos.layoutManager = LinearLayoutManager(this)
        rvListadoContactos.adapter = adapter
    }

    private fun initListeners(){
        btnCheck.setOnClickListener {
            contactos.forEach { contacto ->
                if (contacto.telefono.toString().length == 11){
                    contacto.esCorrecto = true
                } else{
                    contacto.esCorrecto = false
                }
            }
            adapter.notifyDataSetChanged()
        }

        btnInicio.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}