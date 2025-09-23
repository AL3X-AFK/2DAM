package EjerciciosWhenAvanzados

fun main() {
    var boton1 = "R.id.btn1"
    var boton2 = "R.id.btn2"
    var boton3 = "R.id.btn3"
    val botonPresionado = boton2
    when (botonPresionado){
        boton1 -> print("Guardar")
        boton2 -> print("Cancelar")
        boton3 -> print("Eliminar")
    }
}