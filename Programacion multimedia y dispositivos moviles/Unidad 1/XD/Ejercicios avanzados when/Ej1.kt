package EjerciciosWhenAvanzados

fun main() {
    val lista : List<String> = listOf("Jey", "Ronny", "Cristiano")
    lista.forEach { nombre->
        when {
            nombre.length <= 4 -> println(nombre + ": Nombre corto")
            nombre.length in 5..7 -> println(nombre + ": Nombre mediano")
            nombre.length >= 8 -> println(nombre + ": Nombre largo")

        }
    }
}