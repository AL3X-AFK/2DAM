package com.example.miagenda

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ContactosViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvName: TextView = view.findViewById(R.id.tvName)
    private val tvPhone: TextView = view.findViewById(R.id.tvPhone)

    fun render(contacto: Contacto){
        tvName.text = contacto.nombre
        tvPhone.text = contacto.telefono.toString()

        if (contacto.esCorrecto == false){
            tvPhone.setTextColor(ContextCompat.getColor(tvPhone.context, R.color.red))
        } else{
            tvPhone.setTextColor(ContextCompat.getColor(tvPhone.context, R.color.green))

        }
    }
}