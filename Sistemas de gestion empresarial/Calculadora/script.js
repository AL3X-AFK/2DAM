let campoDeTexto = document.getElementById("text")
let igual = document.getElementById("igual")
let numeros = document.querySelectorAll(".numero")
let operadores = document.querySelectorAll(".operador")

let n1 = ""
let n2 = ""


numeros.forEach(boton =>{
    boton.addEventListener("click", () => {
        n1 += boton.value
        campoDeTexto.value = n1
    })
})

operadores.forEach(boton =>{
    boton.addEventListener("click", () =>{
        if (n2 == "") {
            n2 = n1
            n1 = ""
        } else {
            switch (boton.value) {
                case '+':
                    n1 = n2 + n1
                    break;
            
                default:
                    break;
            }
        }
        campoDeTexto.value = ""
    })
})