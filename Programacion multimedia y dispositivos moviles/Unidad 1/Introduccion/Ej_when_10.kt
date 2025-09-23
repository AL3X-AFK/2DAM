package com.example.Introduccion

fun main() {
    var num = 4
    var text:String?= when (num){
        1 -> "Primero"
        2 -> "Segundo"
        3 -> "Tercero"
        4 ->"Cuarto"
        else -> "Desconocido"
    }
    println(text)
}