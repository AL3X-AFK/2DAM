package EjerciciosDeArrays

fun main() {
    var nulos = arrayOfNulls<String>(5)
    val dias = arrayOf("lunes", "martes", "miercoles", "jueves", "viernes")

    for (i in nulos.indices){
        nulos[i] = dias[i]
    }
    print(nulos.joinToString())
}