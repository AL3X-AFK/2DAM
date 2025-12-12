package com.example.Introduccion

fun main() {
    print("Ingresa un numero: ")
    val num1 = try {
        readLine()?.toInt()?:0
    } catch (e: NumberFormatException){
        0
    }
    print("Ingresa otro numero: ")
    val num2 = try {
        readLine()?.toInt()?:0
    } catch (e: NumberFormatException){
        0
    }
    print("El numero mayor es: ")
    if (num1>num2) print(num1) else print(num2)
}
