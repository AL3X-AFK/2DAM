fun main() {
    val mes = 4
    val estacion = when (mes){
        12,1,2 -> "Invierno"
        3,4,5->"Primavera"
        6,7,8->"Verano"
        9,10,11->"Otoño"
        else -> "Error"
    }
    println(estacion)
}