package com.example.Introduccion

fun main() {
    print("Ingresa una nota: ")

    val nota = try {
        readLine()?.toInt()?:0
    } catch (e: NumberFormatException){0}

    when {
        nota in 9..10 -> print("Sobresaliente")
        nota in 7..8 -> print("Notable")
        nota in 5..6 -> print("Aprobado")
        nota < 5 -> print ("Suspenso")
    }
}
