// alert("Hola DAM2, soy una pagina externa")
/*
//Mensajes en consola
console.log("Soy el console.log")
console.info("Soy el console.info")
console.error("Soy el console.error")
console.warn("Soy el console.warn")


// Variable global
var a, b
a = 3
b = 5
var suma = a+b
console.log("El valor de suma1 es: " + suma)

//Variable local

let c,d
c = 1
d = 2
let suma2 = c+d
console.log("El valor de suma2 es: " + suma2)

if (true) {
    let mult = a * b
    var resta = a-b
    console.log("La resta es: " + resta)
    console.log("La multiplicacion es: " + mult)
}
console.log("La resta es: " + resta)
// console.log("La multiplicacion es: " + mult)

const SALUDO = "Hola"
console.log("Te voy a saludar: " + SALUDO)
/*SALUDO = "Bye bye"
console.log("Nos vemos: " + SALUDO)

//Probando los tipos, Numbre
let tres = 3, tresString = "3"

console.log("La vareiable tres es diferente en valor a tresString: " + (tres != tresString))
console.log("La vareiable tres es igual en valor a tresString: " + (tres == tresString))
console.log("La vareiable tres es igual en valor y tipo a tresString: " + (tres === tresString))

//Ejercicios
const total = 142
const personas = 6
console.log("A cada persona le tocara pagar: " + (142/6)) 



let ordenador, cascos, teclado
ordenador = parseInt(prompt("Precio del ordenador: "))
cascos = parseInt(prompt("Precio de los cascos: "))
teclado = parseInt(prompt("Precio del teclado: "))
let gasto =  (ordenador + cascos + teclado) - ((ordenador + cascos + teclado) * 0.10)

let texto = ("Te gastas: " + gasto)
document.getElementById("parrafo").innerHTML = texto
//alert("Gasto " + gasto)

//Probando las propiedades de Number
let num1 = 333
console.log("El tipo de la variable num1 es: " + typeof(num1))

console.log("El tipo de la variable num1 en casting es: " + typeof(num1.toString()))

let fruta = "piña"
console.log("Piña no es un numero?: " + isNaN(fruta))
console.log("Piña no es un numero?: " + isNaN(num1.toString()))

console.log("Num1 con 5 decimales: " + num1.toFixed(5))
*/

/*
let nombre = "Alex"
console.log("Nombre: " + nombre)
console.log(`Nombre: ${nombre}`)

console.log("Longitud de tu nombre: " + nombre.length)

console.log("Typeof de tu nombre: " + typeof(nombre))

console.log("Nombre incluye 'le': " + nombre.includes("le"))

console.log("Nombre recortado: " + nombre.slice(1,4))
let frase = "    No,me,gusta,el,chocolate "
console.log(frase.replaceAll("o", "i"))
console.log("Eliminar espacios antes y despues de la frase: " + frase.trim())
console.log("Separa en un array el String: ")
console.log(frase.split(','))



let nombre = prompt("Cual es su nombre: ")
let edad = parseInt(prompt("Que edad tiene?"))
const CUOTA = 110
let resultado = 0

if(edad >= 64){
    resultado = CUOTA - (CUOTA * 0.3)
} else if (edad >= 34){
    resultado = CUOTA - (CUOTA * 0.1)
} else{
    resultado =  CUOTA
}

let carta = `Hola vecin@ ${nombre}, tienes ${edad} años y por lo tanto, te corresponde pagar ${resultado}`
document.getElementById("parrafo").innerHTML = carta


let conf = confirm("Estas de acuerdo con que los viernes son maravillosos?")
const imagen = document.getElementById("imagen")

if (conf) {
    document.getElementById("parrafo").innerHTML = "Si esta de acuerdo"
    imagen.src="https://media.istockphoto.com/id/157030584/es/vector/bot%C3%B3n-pulgar-levantado-emoticono.jpg?s=612x612&w=0&k=20&c=oH8zfmz-CxHLzQl4YuK4IY4aoFCyIcp8-37N4wYHemI="

} else {
    document.getElementById("parrafo").innerHTML = "No esta de acuerdo"
    imagen.src="https://ih1.redbubble.net/image.4701025867.8070/aps,504x498,medium,transparent-pad,600x600,f8f8f8.u1.jpg"
}


//Operador ternario
const COSTE = 150
let cifra = parseInt(prompt("Dinero: "))
let texto = document.getElementById("parrafo")
cifra>COSTE  ? texto.innerHTML = "Si, te vas de viaje" : texto.innerHTML = "No, te quedas en casa"
*/

