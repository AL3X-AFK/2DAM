fun main() {
    // Creacion de arrays
    // 1. Array explícito
    var numeros = arrayOf(1, 2, 3, 4)
    println(numeros.joinToString()) // 1, 2, 3, 4

    // 2. Array vacío de un tamaño fijo (inicializa con null)
    val nombres = arrayOfNulls<String>(3)
    println(nombres.joinToString()) // null, null, null

    // 3. Array inicializado con una función
    val cuadrados = Array(5) { i -> i * i }
    println(cuadrados.joinToString()) // 0, 1, 4, 9, 16



    // Acceder y modificar
    val letras = arrayOf('a', 'b', 'c')

    println(letras[0]) // 'a'
    letras[1] = 'z'   // cambia el segundo elemento
    println(letras.joinToString()) // a, z, c


    // Recorrer un array
    numeros = arrayOf(10, 20, 30)

    // 1. For clásico
    for (i in numeros.indices) {
        println("Posición $i = ${numeros[i]}")
    }

    // 2. ForEach
    numeros.forEach { println(it) }

    // 3. ForEachIndexed
    numeros.forEachIndexed { i, valor ->
        println("En $i hay $valor")
    }


    // Funciones utiles
    numeros = arrayOf(5, 3, 8, 1)

    println("Tamaño: ${numeros.size}")         // 4
    println("Primero: ${numeros.first()}")     // 5
    println("Último: ${numeros.last()}")       // 1
    println("Máximo: ${numeros.max()}")        // 8
    println("Ordenado: ${numeros.sorted()}")   // [1, 3, 5, 8]


    // Conversión entre arrays y listas
    val array = arrayOf(1, 2, 3)
    val lista = array.toList()
    println(lista) // [1, 2, 3]

    val nuevoArray = lista.toTypedArray()
    println(nuevoArray.joinToString()) // 1, 2, 3

    // Arrays de tipos primitivos
    val intArray = intArrayOf(1, 2, 3)
    val doubleArray = doubleArrayOf(1.0, 2.5, 3.8)

    println(intArray.joinToString())   // 1, 2, 3
    println(doubleArray.joinToString()) // 1.0, 2.5, 3.8
    /*
    Tipos disponibles:
    IntArray, DoubleArray, FloatArray, LongArray, CharArray, BooleanArray, ShortArray, ByteArray.
     */
}
