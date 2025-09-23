package EjerciciosDeArrays

fun main() {
    var numeros = intArrayOf(3,7,1,9)
    var suma = 0
    /*
    numeros.forEach { numero ->
        suma += numero
    }
    */

    for (i in numeros){
        suma += i
    }

    print(suma)
}