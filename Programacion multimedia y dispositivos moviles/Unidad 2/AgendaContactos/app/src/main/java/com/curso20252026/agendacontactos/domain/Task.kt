package com.curso20252026.agendacontactos.domain

data class Task(
    val id: Int = 0,
    val title: String,
    val isDone: Boolean = false
)