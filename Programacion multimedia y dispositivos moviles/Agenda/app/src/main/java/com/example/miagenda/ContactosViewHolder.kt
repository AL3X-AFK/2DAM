package com.example.miagenda

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvName: TextView = view.findViewById(R.id.tvName)
    private val tvPhone: TextView = view.findViewById(R.id.tvPhone)

    fun render(contacto: Contacto){
        tvName.text = contacto.nombre
        tvPhone.text = contacto.telefono.toString()
    }
}