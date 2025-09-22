package com.example.Introduccion

fun main() {
    println("Introduce la nota")
    val nota = try {
        readLine()?.toInt()?:0
    } catch (e: NumberFormatException){
        0
    }
    if (nota >= 5){
        println("APTO")
    } else{
        println("NO APTO")
    }
}
