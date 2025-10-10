let boton1 = document.createElement("input")
let cuerpo = document.body
let arrayImagenes = document.getElementsByTagName("img")
let imagen0 = document.getElementsByTagName("img")[0]


boton1.type="button"
boton1.setAttribute("value", "Pulsa aqui")

imagen0.style.width="200px"

console.log(arrayImagenes)
console.log(imagen0)

let p1 = document.createElement("p")
p1.textContent="Hola esto es un parrafo"

let tittle1 = document.createElement("h1")
tittle1.textContent = "Hola esto es un titulo H1"
tittle1.style.fontFamily="Agency fb"

let imagen1 = document.createElement("img")
imagen1.src="https://yt3.googleusercontent.com/2iZVwc0I5p5lt7NSsrPF89FYE20GbhioJJSsZSnBL13ztT-CLbGbAV2BUhvRfJcrUnnJ0dyJig=s900-c-k-c0x00ffffff-no-rj"
imagen1.style.width="200px"

let imagen2 = document.createElement("img")
imagen2.src="https://yt3.googleusercontent.com/SRt9vv0Bro9zwkR_un3l2vSknLKLLLM6dJihFqHbbbZm_AEUmFuaWOxFNxe8LizPFVJ3_OViJW0=s176-c-k-c0x00ffffff-no-rj-mo"
imagen2.style.width="200px"


cuerpo.appendChild(boton1)
cuerpo.appendChild(tittle1)
cuerpo.appendChild(p1)
cuerpo.appendChild(imagen1)
cuerpo.appendChild(imagen2)


let link = document.getElementsByTagName("a")[0]

cuerpo.removeChild(link)

cuerpo.insertBefore(tittle1, imagen0)

let lista = document.createElement("select")

let opcion1 = document.createElement("option")
opcion1.textContent="Patata"
let opcion2 = document.createElement("option")
opcion2.textContent="Esparragos"
let opcion3 = document.createElement("option")
opcion3.textContent="Ciruela"

lista.append(opcion1)
lista.append(opcion2)
lista.append(opcion3)

cuerpo.appendChild(lista)

console.log(arrayImagenes)
console.log(link)
console.log(lista)
