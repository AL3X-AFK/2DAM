package com.example.Introduccion

fun main() {
    print("1. Saludar\n2. Mostrar hora actual\n3. Salir")
    print("\nIngresa una opcion: ")
    val opcion = readLine()
    val num = opcion?.toIntOrNull()?: 3

    when (num){
        1 -> print("Buenos dias")
        2 -> print(java.time.LocalTime.now())
        3 -> print("Saliendo del programa")
        else -> print("Valor no valido")
    }
}