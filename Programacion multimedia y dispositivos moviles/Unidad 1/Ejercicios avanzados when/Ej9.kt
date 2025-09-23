package EjerciciosWhenAvanzados

open class Animal{
}
class Perro : Animal(){
}
class Gato : Animal(){
}
class Pajaro : Animal(){
}

fun identificarAnimal(animal: Animal){
    when (animal){
        is Perro -> println("Es un perro")
        is Gato -> println("Es un gato")
        is Pajaro -> println("Es un pajaro")
        else -> println("Otro animal")
    }
}

fun main() {
    val a1 = Perro()
    val a2 = Gato()

    identificarAnimal(a1)
    identificarAnimal(a2)
}