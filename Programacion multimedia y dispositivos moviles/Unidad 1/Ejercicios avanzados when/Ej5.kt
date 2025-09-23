package EjerciciosWhenAvanzados

fun main() {
    var num = 80
    when {
        num in 0..50 -> print("Bajo")
        num in 51..100 -> print("Medio")
        num > 100 -> print("Alto")
        num < 0 -> print("Negativo")
    }
}