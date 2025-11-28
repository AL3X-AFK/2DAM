let campoDeTexto = document.getElementById("text")
let igual = document.getElementById("igual")

let botones = document.querySelectorAll("input[type=button]")

let operacion = ""

botones.forEach(boton => {
    boton.addEventListener("click", ()=>{
    if (boton.value == '=') {
        try {
            campoDeTexto.value = eval(operacion)
            operacion = campoDeTexto.value

        } catch (error) {
            campoDeTexto.value = "ERROR"
            operacion = ""
        }

    } else if(boton.value == 'C'){
        campoDeTexto.value = ""
        operacion = ""
        
    }else {
        operacion += boton.value
        campoDeTexto.value = operacion
    }
    })
    
});

/*
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
*/