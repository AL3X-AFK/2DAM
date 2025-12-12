package EjerciciosWhenAvanzados

fun main() {
    val x: Int = 5
    val y: Int = -2
    when{
        x>0 && y>0 -> print("Ambos positivos")
        x > 0 || y > 0 -> print("Al menos uno es positivo")
        x == 0 && y == 0 -> print("Ambos cero")
        else -> print("Error")
    }
}