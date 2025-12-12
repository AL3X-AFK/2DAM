package com.example.EjerciciosFor

fun main() {
    val valores = arrayOf(5,10,15,20)
    var suma = 0
    for (i in valores){
        suma += i
    }
    print("Resultado: $suma")
}