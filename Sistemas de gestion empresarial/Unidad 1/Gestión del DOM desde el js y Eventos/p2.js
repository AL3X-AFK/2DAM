let titulo = document.createElement("h1")
titulo.innerHTML= "Mi cuadro de color"
document.body.appendChild(titulo)



let div = document.createElement("div")
div.style.width="200px"
div.style.height="200px"
div.style.backgroundColor="red"
document.body.appendChild(div)

div.addEventListener("mouseenter", ()=>{
    div.style.border="5px solid black"
})
div.addEventListener("mouseleave", ()=>{
    div.style.border="0px solid black"
})


let input = document.createElement("input")
input.type = "color"
document.body.appendChild(input)



let boton = document.createElement("button")
boton.textContent ="Cambiar color"
document.body.appendChild(boton)

boton.addEventListener("click", ()=>{
    div.style.backgroundColor = input.value
})



let parrafo = document.createElement("p")
parrafo.textContent = " clicks en el cuadro de color"
document.body.appendChild(parrafo)

let contador = 0
div.addEventListener("click", ()=>{
    contador ++
    parrafo.textContent = contador + " clicks en el cuadro de color"
})

