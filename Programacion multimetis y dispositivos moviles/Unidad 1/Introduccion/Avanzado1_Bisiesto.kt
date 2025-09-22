fun main() {

    var year = 2004

    when {
        (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 -> print("Año bisiesto")
        else -> print("El año no es bisiesto")
    }
}