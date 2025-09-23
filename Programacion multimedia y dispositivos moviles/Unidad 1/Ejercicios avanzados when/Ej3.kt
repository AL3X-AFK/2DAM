package EjerciciosWhenAvanzados
fun funcion (valor: Int){
    when {
        valor > 0 && (valor%2) != 0 -> print("Positivo impar")
        valor > 0 -> print("Positivo")
        valor < 0 -> print("Negativo")
        else -> print("Cero")
    }
}
fun main() {
    funcion(5)
}