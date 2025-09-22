fun main() {
    var x :Any = listOf(1, 2, 3)
    when (x){
        is List<*> -> print("Es list con tamaño de " + x.size)
        is Set<*> -> print("Es set con tamaño de " + x.size)
        is Map<*, *> -> print("Es map con tamaño de " + x.size)
        else -> print("No es ninguna de las opciones")
    }
}