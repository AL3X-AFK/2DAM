package com.example.Introduccion

fun main() {
    var num : Int?= 6

    num?.let{
        println(num*2)
    }
}
