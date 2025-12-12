package com.example.EjerciciosFor

fun main() {
    var ml = mutableListOf<Int>()
    val lista = listOf(2, 6, 8, 1, 9)

    for (i in lista){
        if (i > 5){
            ml.add(i)
        }
    }
    
    print(ml)
}