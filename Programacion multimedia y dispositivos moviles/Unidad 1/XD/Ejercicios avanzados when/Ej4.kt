package EjerciciosWhenAvanzados
fun funcion (dia: String): String{

    when (dia){
        "Lunes","Martes","Miercoles","Jueves","Viernes" -> return "Laborable"
        "Sabado", "Domingo" -> return "Fin de semana"
        else-> return "Dia invalido"
    }
}
fun main() {
    var texto = "Lunes"
    print(funcion(texto))
}