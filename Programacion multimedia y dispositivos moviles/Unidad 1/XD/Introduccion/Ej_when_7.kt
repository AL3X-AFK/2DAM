package com.example.Introduccion

fun main() {
    var edad = 150
    when(edad){
        in 0..2 -> print("Bebé")
        in 3..12 -> print("Niño")
        in 13..17 -> print("Adolescente")
        in 18..64 -> print("Adulto")
        else -> print ("Mayor")
    }
}