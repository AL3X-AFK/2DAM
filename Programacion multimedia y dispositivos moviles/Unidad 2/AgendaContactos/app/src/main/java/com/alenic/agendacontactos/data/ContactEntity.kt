package com.alenic.agendacontactos.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val phone: String
)