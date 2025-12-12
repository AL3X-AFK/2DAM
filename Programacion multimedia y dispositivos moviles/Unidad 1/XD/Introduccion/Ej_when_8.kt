package com.example.Introduccion

fun main() {
    var num: Int = 15

    when{
        num%3== 0 && num % 5==0 -> print("Múltiplo de 3 y 5")
        num%3==0 -> print("Múltiplo de 3")
        num%5==0 -> print("Múltiplo de 5")
        else -> print("Ninguno")
    }

}