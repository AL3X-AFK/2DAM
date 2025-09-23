package EjerciciosWhenAvanzados

fun main() {
    var caracter = 'C'
    when (caracter){
        'a','e','i','o','u' -> print("Vocal minuscula")
        'A','E','I','O','U' -> print("Vocal mayuscula")
        in 'a'..'z' , in 'A'..'Z' -> print("Consonante")
        else -> print("Otro")
    }
}