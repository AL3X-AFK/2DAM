package EjerciciosDeArrays

fun main() {
    var a1 = arrayOf(10,20,30,40)
    print("Ingrese un nuemro: ")
    var num = try {
        readLine()!!.toInt()
    } catch (e: NumberFormatException){
        print("Entrada invalida")
    }

    var encontrado = false

    for (i in a1.indices){
        if (a1[i] == num){
            println("El nuemro esta en la posicion: " + i)
            encontrado = true
            return
        }
    }
    if (!encontrado){
        print("No se encuentra el numero" )
    }
}