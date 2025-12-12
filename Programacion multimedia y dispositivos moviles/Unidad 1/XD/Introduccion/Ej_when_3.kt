package com.example.Introduccion

fun main() {
    val caracter = "?"

    when (caracter){
        "a", "e", "i", "o","u" -> print("Vocal")
        in "a".."z" -> print ("Consonante")
        else -> print("Otro caracter")
    }

}