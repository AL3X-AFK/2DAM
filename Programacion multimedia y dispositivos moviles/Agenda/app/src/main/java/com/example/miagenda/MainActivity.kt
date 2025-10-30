package com.example.miagenda

import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val contactos = mutableListOf<Contacto>(
        Contacto("Lucas", 87654121011),
        Contacto("Juan", 687854412),
        Contacto("Ana", 632145698),
        Contacto("Marta", 12345678987)
    )
    lateinit var rvListadoContactos: RecyclerView
    lateinit var fabAddContact: FloatingActionButton

    lateinit var adapter: ContactosAdapter

    lateinit var btnCheck: Button


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
        //fabAddContact = findViewById(R.id.fabAddContact)
        btnCheck = findViewById(R.id.btnCheck)
    }

    private fun initUi() {
        adapter = ContactosAdapter(contactos)
        rvListadoContactos.layoutManager = LinearLayoutManager(this)
        rvListadoContactos.adapter = adapter
    }
    private fun initListeners() {
        /*fabAddContact.setOnClickListener {

        }*/
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
    }


}