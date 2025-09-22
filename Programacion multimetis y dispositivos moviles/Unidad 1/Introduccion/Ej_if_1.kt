package com.example.Introduccion

fun main() {
    println("Introduce un número")
    val numero = try {
        readLine()?.toInt()?:0
    } catch (e: NumberFormatException){
        0
    }
    if (numero > 0){
        println("Es positivo")
    } else if (numero == 0){
        println("Es cero")
    } else {
        println("Es negativo")
    }

}