package EjerciciosDeArrays

import kotlin.math.sin

fun main() {
    var numeros = arrayOf(1, 2, 3, 4, 5)
    val sinTres = numeros.filter { it != 3 }

    print(sinTres.joinToString())
}