package com.example.miagenda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val contactos = mutableListOf<Contacto>(
        Contacto("Lucas", 698765412),
        Contacto("Juan", 687854412),
        Contacto("Ana", 632145698)
    )
    lateinit var rvListadoContactos: RecyclerView
    lateinit var fabAddContact: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initComponents()
        initUi()
        initListeners()

    }

    private fun initComponents() {
        rvListadoContactos = findViewById<RecyclerView>(R.id.rvListadoContactos)
        fabAddContact = findViewById(R.id.fabAddContact)
    }

    private fun initUi() {
        contactosAdapter = ContactosAdapter(contactos)
        rvListadoContactos.layoutManager = LinearLayoutManager(this)
        rvListadoContactos.adapter = contactosAdapter
    }
    private fun initListeners() {
        fabAddContact.setOnClickListener {

        }
    }


}