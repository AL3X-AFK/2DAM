package com.example.miagenda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactosAdapter(private val contactos: List<Contacto>): RecyclerView.Adapter<ContactosViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactosViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ContactosViewHolder,
        position: Int
    ) {
        holder.render(contactos[position])
    }

    override fun getItemCount(): Int = contactos.size
}