//alert("Esta ok")
let cuerpo = document.body
cuerpo.style.backgroundColor = "#E3701E"

let texto1 = document.getElementById("id_nombre")
let texto2= document.getElementById("id_correo")
let texto3 = document.getElementById("id_edad")

texto1.style.backgroundColor="#66c1e5ff"
texto1.style.color='blue'
texto1.style.fontFamily="Broadway"

texto1.value="Alex"
texto2.value="a@gmail.com"
texto3.value=21

console.log("Nombre: " + texto1.value)
console.log("Correo: " + texto2.value)
console.log("Correo: " + texto3.value)

let btn1 = document.createElement("button")
btn1.value="Boton1"
cuerpo.append(btn1)