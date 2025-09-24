package EjerciciosDeArrays

fun main() {
    var numeros = intArrayOf(1,2,3,4,5)

    var cuadrados = IntArray(numeros.size)

    for (i in numeros.indices){
        cuadrados[i] = numeros[i] * numeros[i]
    }

    print(cuadrados.contentToString())
}