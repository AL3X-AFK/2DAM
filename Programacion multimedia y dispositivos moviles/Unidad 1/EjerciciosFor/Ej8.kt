package com.example.EjerciciosFor

fun main() {
    val persona = mapOf("nombre" to "Ana", "edad" to 30, "ciudad" to "Madrid")

    for ((clave, valor) in persona){
        println("$clave -> $valor")
    }
}