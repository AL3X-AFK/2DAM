package com.example.Introduccion

fun main() {
    var temp = 4

    when{
        temp < 0 -> print("Congelado")
        temp in 0..15  -> print("Frío")
        temp in 16..25 -> print("Templado")
        temp >25 -> print("Calor")
    }
}