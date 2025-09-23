package com.example.Introduccion

fun main() {
    val num: Int ?= 5
    when(num){
        1 -> println("Lunes")
        2 -> println("Martes")
        3 -> println("Miercoles")
        4 -> println("Jueves")
        5 -> println("Viernes")
        6 -> println("Sabado")
        7 -> println("Domingo")
        else -> println("Numero no valido")
    }
}
