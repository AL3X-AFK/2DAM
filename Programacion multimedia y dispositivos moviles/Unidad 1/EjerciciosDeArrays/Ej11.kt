package EjerciciosDeArrays

fun main() {
    var numeros = arrayOf(1,2,2,3,2,4)
    var contador = 0
    for (i in numeros.indices){
        if (numeros[i] == 2 ){
            contador ++
        }
    }
    print("El numero 2 aparece: $contador veces")

}