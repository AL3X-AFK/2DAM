package com.example.Introduccion

fun main() {
    var x: Any
    x = "hola"

    when (x){
        is String -> println(x.length)
        is Int -> println(x*2)
        is Boolean -> if (x == true) print("Es verdadero") else print("Es falso")
        else -> println("Tipo no reconocido")
    }
}