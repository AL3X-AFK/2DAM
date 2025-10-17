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
*/