package EjerciciosWhenAvanzados


fun funcion (variable: Any?){
    when (variable){
        is String ->
            print("Es un string " + (if (variable.isBlank()){""} else {variable.length}))
        is Int -> print("Es un Int " + (variable * variable))
        null -> print("Es nulo")
        else -> print("Otro tipo")
    }
}
fun main() {
    var x: Any ?= null
    funcion(x)
}