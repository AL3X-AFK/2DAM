/*
// 1. Escribe un programa de una sola línea que haga que aparezca en la pantalla un alert que salude con el nombre de la persona que ejecuta el programa (se pide por teclado) “Hola Celia”.
let texto = "Hola " + prompt("Ingresa tu nombre: ")
alert(texto)

// 2. Escribe un programa de una sola línea que escriba en el HTML el mismo texto (document.write).
document.writeln(texto)

// 3. Escribe un programa de una sola línea que escriba en la pantalla el resultado de sumar 3 + 5. 
document.writeln(3+5)

// 4. Escribe un programa de tres líneas que pida un número, pida otro número y escriba el resultado de sumar estos dos números.
let n1 = parseInt(prompt("Ingresa un numero: "))
let n2 = parseInt(prompt("Ingresa otro numero: "))
document.writeln(n1+n2)

// 5. Escribe un programa que pida dos números y escriba en la pantalla cual es el mayor.
let n1 = parseInt(prompt("Ingresa un numero: "))
let n2 = parseInt(prompt("Ingresa otro numero: "))
n1>n2 ? document.writeln(n1):document.writeln(n2) 

// 6. Escribe un programa que pida 3 números y escriba en la pantalla el mayor de los tres.
let n1 = parseInt(prompt("Ingresa un numero: "))
let n2 = parseInt(prompt("Ingresa otro numero: "))
let n3 = parseInt(prompt("Ingresa otro numero: "))
if (n1 > n2 && n1 > n3) {
    document.writeln("El mayor es: "+n1)
}else if(n2>n1 && n2>n3){
    document.writeln("El mayor es: "+n2)
}else{
    document.writeln("El mayor es: "+n3)
}

// 7. Escribe un programa que pida un número y diga si es divisible por 2.
let num = parseInt(prompt("Ingresa un numero: "))
num%2==0? document.writeln("Si es divisible para 2"):document.writeln("No es divisible para 2")

// 8. Escribe un programa que pida una frase y escriba cuantas veces aparece la letra a.
let frase = prompt("Ingresa una frase: ")
frase = frase.toLowerCase()
let cantidad = 0
for (let i = 0; i < frase.length; i++) {
    if (frase[i] == 'a'){
        cantidad = cantidad+1
    }
}
document.writeln("Hay " + cantidad + " letras 'a'")

// 9. Escribe un programa que pida una frase y escriba las vocales que aparecen.
let frase = prompt("Ingresa una frase: ")
frase = frase.toLowerCase()
let vocales = ['a','e','i','o','u']
let salida = ""
for (let i = 0; i < frase.length; i++) {
    if (vocales.includes(frase[i])) {
        salida += frase[i] +" "
    }
}
document.writeln("Hay las vocales: " + salida)

// 10. Escribe un programa que pida una frase y escriba cuántas de las letras que tiene son vocales.
let frase = prompt("Ingresa una frase")
frase = frase.toLowerCase()
let vocales = ['a','e','i','o','u']
let cantidadVocales = 0
for (let i = 0; i < frase.length; i++) {
    if (vocales.includes(frase[i])) {
        cantidadVocales += 1
    }
}
document.writeln("Hay "+cantidadVocales+" vocales")


// 11. Escribe un programa que pida una frase y escriba cuántas veces aparecen cada una de las vocales.
let frase = prompt("Ingresa una frase")
frase = frase.toLowerCase()
let a=0, e=0, i=0, o=0, u=0
for (let x = 0; x < frase.length; x++) {
    switch (frase[x]) {
        case 'a': a+=1
            break;
        case 'e': e+=1
            break;
        case 'i': i+=1
            break;
        case 'o': o+=1
            break;
        case 'u': u+=1
            break;
        default:
            break;
    }
}
let p1 = document.createElement("p")
p1.innerHTML = 'A: ' +a + '<br>E: ' +e + '<br>I:  ' +i + '<br>O: ' +o + '<br>U: ' +u
document.body.appendChild(p1)

// 12. Escribe un programa que pida un número y nos diga si es divisible por 2, 3, 5 o 7 (sólo hay que comprobar si lo es por uno de los cuatro).

let num = parseInt(prompt("Ingresa un numero"))
let salida = ""
if(num %2 == 0){
    salida += "Es divisible para dos"
}else if(num %3 == 0){
    salida += "Es divisible para tres"
}else if(num %5 == 0){
    salida += "Es divisible para cinco"
}else if(num %7 == 0){
    salida += "Es divisible para siete"
}
let p1 = document.createElement("p")
p1.innerHTML=salida
document.body.appendChild(p1)


// 13. Añadir al ejercicio anterior que nos diga por cuál de los cuatro es divisible (hay que decir todos por los que es divisible).
let num = parseInt(prompt("Ingrese un numero"))
let divisoresEncontrados = []
if(num %2 == 0){
    divisoresEncontrados.push(2)
}
if(num %3 == 0){
    divisoresEncontrados.push(3)

}
if(num %5 == 0){
    divisoresEncontrados.push(5)
}
if(num %7 == 0){
    divisoresEncontrados.push(7)
}

let p1 = document.createElement("p")
p1.innerHTML="Divisible para: " + divisoresEncontrados
document.body.appendChild(p1)
console.log(divisoresEncontrados)


// 14. Escribir un programa que escriba en pantalla los divisores de un número dado.
let num = parseInt(prompt("Ingresa un numero: "))
let divisores = []
for (let i = 0; i < num+1; i++) {
    if (num % i == 0) {
        divisores.push(i)
    }
}
let p = document.createElement("p")
p.innerHTML=num + " Es divible para:  " + divisores
document.body.appendChild(p)


// 15. Escribir un programa que escriba en pantalla los divisores comunes de dos números dados.
let n1 = parseInt(prompt("Ingresa el primer numero"))
let n2 = parseInt(prompt("Ingresa el segundo numero"))
let divisores = []
for (let i = 0; i < n1 + 1; i++) {
    if (n1 % i == 0 && n2 % i == 0) {
        divisores.push(i)
    }    
}

let p = document.createElement("p")
p.innerHTML="Los divisores comunes de " + n1 +" y " + n2 + " son: "+ divisores
document.body.appendChild(p)


// 16. Escribir un programa que nos diga si un número dado es primo (no es divisible por ninguno otro número que no sea él mismo o la unidad).
let num = parseInt(prompt("Ingresa el numero"))
let divisores = 0
let salida
for (let i = 0; i < num+1; i++) {
    if (num % i == 0) {
        divisores += 1
    }
}
if (divisores == 2) {
    salida = "Es primo"
} else {
    salida = "No es primo"
}
let p = document.createElement("p")
p.innerHTML = salida
document.body.appendChild(p)


// 17. Escribe un programa que pregunte el nombre del usuario en la consola y un número entero e imprima por pantalla en líneas distintas el nombre del usuario tantas veces como el número introducido.
let nombre = prompt("Ingresa tu nombre")
let num = parseInt(prompt("Ingresa un numero"))
let p = document.createElement("p")
for (let i = 0; i < num; i++) {
    p.innerHTML+= nombre + "<br>"
}
document.body.appendChild(p)


// 18. Escribe un programa que pregunte el nombre completo del usuario en la consola y después muestre por pantalla el nombre completo del usuario tres veces, una con todas las letras minúsculas, otra con todas las letras mayúsculas y otra solo con la primera letra del nombre y de los apellidos en mayúscula. El usuario puede introducir su nombre combinando mayúsculas y minúsculas como quiera.
let nombre = prompt("Ingresa tu nombre")
console.log(nombre)
let minusculas = nombre.toLowerCase()
console.log(minusculas)

let mayusculas = nombre.toUpperCase()
console.log(mayusculas)

let array = nombre.split(' ')
console.log(array)

let capital = []

for (let i = 0; i < array.length; i++) {
    let palabra = array[i].charAt(0).toUpperCase() + array[i].slice(1).toLowerCase()
    capital.push(palabra)
}

capital = capital.join(" ")
console.log(capital)

let p = document.createElement("p")
p.innerHTML=minusculas+"<br>"+mayusculas+"<br>"+capital
document.body.appendChild(p)


// 19. Escribe un programa que pregunte el nombre del usuario en la consola y después de que el usuario lo introduzca muestre por pantalla <NOMBRE> tiene <n> letras, donde <NOMBRE> es el nombre de usuario en mayúsculas y <n> es el número de letras que tienen el nombre.
let nombre = prompt("Ingresa el nombre")
nombre = nombre.toUpperCase()
let n = nombre.length

let p = document.createElement("p")
p.innerHTML = nombre + " tiene " + n + " letras" 
document.body.appendChild(p)


// 20. Los teléfonos de una empresa tienen el siguiente formato prefijo-número-extension donde el prefijo es el código del país +34, y la extensión tiene dos dígitos (por ejemplo +34-913724710-56). Escribir un programa que pregunte por un número de teléfono con este formato y muestre por pantalla el número de teléfono sin el prefijo y la extensión.
let tel = prompt("Ingresa un numero de teleono con el formato (+34-913724710-56)")
let arrayTel = tel.split('-')
console.log(arrayTel)
let numSolo = arrayTel[1]
let p = document.createElement("p")
p.innerHTML="Numero solo: " + numSolo
document.body.appendChild(p)


// 21. Escribe un programa que pida al usuario que introduzca una frase en la consola y muestre por pantalla la frase invertida.
let frase = prompt("Ingresa una frase")
let invertida = ""
for (let i = frase.length - 1; i >=0 ; i--) {
    invertida += frase[i]
}
console.log(invertida)

let p = document.createElement("p")
p.innerHTML="Frase invertida: " + invertida
document.body.appendChild(p)


// 22. Escribe un programa que pida al usuario que introduzca una frase en la consola y una vocal, y después muestre por pantalla la misma frase pero con la vocal introducida en mayúscula.
let frase = prompt("Ingresa una frase")
let frase2 = ""
let letra = prompt("Ingresa una vocal")
for (let i = 0; i < frase.length; i++) {
    if (frase[i] == letra) {
        frase2 += frase[i].toUpperCase()
    }else{
        frase2 += frase[i]
    }
}
console.log(frase2)


// 23. Escribe un programa que pregunte el correo electrónico del usuario en la consola y muestre por pantalla otro correo electrónico con el mismo nombre (la parte delante de la arroba @) pero con dominio ceu.es.
let correo = prompt("Ingresa tu correo")

let p = document.createElement("p")
p.innerHTML="Tu correo sera: " + convCorreo(correo)
document.body.appendChild(p)

function convCorreo(correo) {
    let array = correo.split('@')
    let correoNuevo = array[0] + "@ceu.es."
    return correoNuevo
}

*/

// 24. Escribe un programa que pregunte por consola el precio de un producto en euros con dos decimales y muestre por pantalla el número de euros y el número de céntimos del precio introducido.



// 25. Escribe un programa que pregunte al usuario la fecha de su nacimiento en formato dd/mm/aaaa y muestra por pantalla, el día, el mes y el año. Adaptar el programa anterior para que también funcione cuando el día o el mes se introduzcan con un solo carácter.


// 26. Escribe un programa que pregunte por consola por los productos de una cesta de la compra, separados por comas, y muestre por pantalla cada uno de los productos en una línea distinta.


// 27. Escribe un programa que pregunte el nombre el un producto, su precio y un número de unidades y muestre por pantalla una cadena con el nombre del producto seguido de su precio unitario con 6 dígitos enteros y 2 decimales, el número de unidades con tres dígitos y el coste total con 8 dígitos enteros y 2 decimales.


// 28. Escribe una función que reciba como argumento una cadena de caracteres y devuelva una cadena con todas las vocales y el número de veces que aparece cada una en la cadena argumento.

// 29. Escribe una función que reciba como argumento una frase con letras y números. La función debe devolver la suma de todos los dígitos contenidos en la frase.

// 30. Escribe una función javascript que reciba como argumento una frase y que devuelva el número de espacios, dígitos y letras contenidos en la frase.

// 31. Escribe una función recursiva que cuente el número de veces que un carácter dado aparece en una cadena. La función recibe como argumentos la cadena y el carácter buscado.

// 32. Escribe una función que reciba como argumento una frase y devuelva la misma frase pero con la inicial de cada palabra en mayúsculas.