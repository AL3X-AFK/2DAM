package EjerciciosDeArrays

fun main() {
    var numeros = intArrayOf(2,5,8,11,14,17)
    var pares = numeros.filter { it % 2 == 0 }
    println(pares)

}