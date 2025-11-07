
// Ejercicio 1
document.getElementById("rojo").addEventListener("click", ()=>{
    document.body.style.backgroundColor="red"
})
document.getElementById("verde").addEventListener("click", () =>{
    document.body.style.backgroundColor="green"
})
document.getElementById("azul").addEventListener("click", () =>{
    document.body.style.backgroundColor="blue"
})
document.getElementById("blanco").addEventListener("click", () =>{
    document.body.style.backgroundColor="#f4f4f9"
})

//Ejercicio 2
document.getElementById("nombre").addEventListener("input", () => {
    document.getElementById("saludo").innerHTML = "¡Hola, " + document.getElementById("nombre").value + "!" ;
});

//Ejercicio 3
let nuevoElemento = document.getElementById("nuevoElemento")
let botonAñadir = document.getElementById("añadir")
let lista  = document.getElementById("lista")
botonAñadir.addEventListener("click", () => {
    let item = document.createElement("li")
    item.textContent = nuevoElemento.value
    lista.appendChild(item)
    nuevoElemento.value = ""

    item.addEventListener("click", () =>{
    item.remove()
    })

})


//Ejercicio 4
let contador = document.getElementById("contador")
let resultado = document.getElementById("resultado")
let cont = 0
contador.addEventListener("click", () =>{
    cont ++
    resultado.textContent="Has hecho click " + cont + " veces."
    if (cont % 5 == 0) {
        contador.style.backgroundColor = "purple"
    } else{
        contador.style.backgroundColor="#0078D7"
    }
})

//Ejercicio 5
let anioNacimiento = document.getElementById("anioNacimiento")
let calcularEdad = document.getElementById("calcularEdad")
let resultadoEdad = document.getElementById("resultadoEdad")
calcularEdad.addEventListener("click", () =>{
    let edad = 2025 - anioNacimiento.value
    resultadoEdad.textContent = "Tienes " + edad + " años."
    if (edad < 18){
        resultadoEdad.style.color = "red"
    } else {
        resultadoEdad.style.color = "black"
    }
})

//Ejercicio 6
let numeroRandom = Math.floor(Math.random() * 10) + 1
let numeroUsuario = document.getElementById("numeroUsuario")
let comprobar = document.getElementById("comprobar")
let mensaje = document.getElementById("mensaje")
comprobar.addEventListener("click", () =>{
    if (numeroUsuario.value == numeroRandom){
        mensaje.textContent = "¡Has adivinado!"
    } else {
        mensaje.textContent = "¡No es correcto, intentalo de nuevo!"
    }
    let reiniciar = document.createElement("button")
    reiniciar.textContent="Reiniciar"
    reiniciar.style.backgroundColor="#0078D7"
    reiniciar.addEventListener("click", () =>{
        numeroRandom = Math.floor(Math.random() * 10) + 1
        numeroUsuario.value = ""
        reiniciar.remove()
        mensaje.textContent = ""
    })
    mensaje.appendChild(reiniciar)
})

//Ejercicio 7
let seccion = document.getElementById("seccion")
let textTarea = document.createElement("input")
textTarea.type = "text"
textTarea.placeholder="Añade una tarea"
let addTarea = document.createElement("button")
addTarea.textContent = "Añadir Tarea"
addTarea.style.backgroundColor="#0078D7"
let dropAll = document.createElement("button")
dropAll.textContent = "Borrar Todo"
dropAll.style.backgroundColor="#0078D7"

let listaTareas = document.getElementById("listaTareas")

seccion.appendChild(textTarea)
seccion.appendChild(addTarea)
seccion.appendChild(dropAll)
seccion.appendChild(listaTareas)

addTarea.addEventListener("click", () => {
    let tarea = document.createElement("li")
    tarea.textContent = textTarea.value
    listaTareas.appendChild(tarea)
    textTarea.value=""
})

dropAll.addEventListener("click", () => {
    listaTareas.innerHTML = ""
    textTarea.value=""
})