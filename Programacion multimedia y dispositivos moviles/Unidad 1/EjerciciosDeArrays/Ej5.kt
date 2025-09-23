package EjerciciosDeArrays

fun main() {
    var numeros =  intArrayOf(10, 5, 22, 7, 1, 8)

    println("Valor maximo: " + numeros.max())
    println("Valor minimo: " + numeros.min())
    println("La diferencia entre ellos: " + (numeros.max() - numeros.min()))
}