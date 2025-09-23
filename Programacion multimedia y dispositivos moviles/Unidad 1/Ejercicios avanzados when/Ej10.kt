package EjerciciosWhenAvanzados

fun main() {
    var edades = listOf(3,5,10,15,20,100)
    val categorias = edades.map { edad->
        when (edad){
            in 0..12 -> "Niño"
            in 13..17 -> "Adolescente"
            in 18..64 -> "Adulto"
            else -> "Mayor"
        }
    }
    print(categorias)
}