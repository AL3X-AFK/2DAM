package com.example.Introduccion

import java.lang.NumberFormatException

fun main() {
    print("Ingresa un numero: ")
    var n1 = try {
        readLine()?.toInt()?: 0
    } catch (e: NumberFormatException){0}

    print ("Ingresa otro numero: ")
    var n2 = try {
        readLine()?.toInt()?:0
    }catch (e: NumberFormatException){0}

    print("Ingresa un operador: ")
    var op = readLine()

    when (op){
        "+" -> print(n1 + n2)
        "-" -> print(n1 - n2)
        "*" -> print(n1 * n2)
        "/" -> print(n1 / n2)
        else -> print("No valido")

    }
}