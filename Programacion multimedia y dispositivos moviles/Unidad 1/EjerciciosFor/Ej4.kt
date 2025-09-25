package com.example.EjerciciosFor

fun main() {
    val numeros = listOf(3,7,9,10,15,20)
    for (i in numeros){
        if (i > 10){
            println("El primer numero mayor que 10 es: $i")
            break
        }
    }
}