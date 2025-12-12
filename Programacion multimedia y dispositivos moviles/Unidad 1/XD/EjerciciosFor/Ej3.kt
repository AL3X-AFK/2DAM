package com.example.EjerciciosFor

fun main() {
    val frutas = listOf("Manzana", "Banana", "Fresa")
    for ((index, value) in  frutas.withIndex()){
        println("Fruta $index : $value")
    }
}