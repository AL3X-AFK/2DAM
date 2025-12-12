package EjerciciosDeArrays

import kotlin.system.exitProcess

fun main() {
    var nombres = arrayOf("Ana", "Luis", "Eva", "Pablo")

    println("Ingresa un nombre: ")
    var nombre = readLine()
    var encontrado = false

    nombres.forEach { x ->
        if (nombre == x){
            println("Nombre encontrado")
            encontrado = true
            return
        }
    }
    if (!encontrado){
        println("No existe el nombre")
    }


}