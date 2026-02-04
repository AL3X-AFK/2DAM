package com.curso20252026.agendacontactos.domain

data class Contact(
    val id : Int = 0,
    val name: String,
    val phone: String,
    val address: String,
    val tasks : List<Task> = emptyList()
){
    val statisColor: String
        get() = when{
            tasks.isEmpty() -> "GRAY"
            tasks.any { !it.isDone } -> "RED"
            else -> "GREEN"
        }
}