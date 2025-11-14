const tablero = document.getElementById("id_tablero");
let cartasVolteadas = [];
const cartas = [
  "🐶",
  "🐱",
  "🐭",
  "🐹",
  "🐰",
  "🦊",
  "🐻",
  "🐼",
  "🐶",
  "🐱",
  "🐭",
  "🐹",
  "🐰",
  "🦊",
  "🐻",
  "🐼",
];

function mezclarCartas(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
}

function crearCarta(emoji, index) {
  const carta = document.createElement("div");
  carta.classList.add("carta");
  carta.textContent = emoji;
  carta.id = "id_carta" + index;
  return carta;
}

function voltearCarta(carta) {
    if (carta.style.backgroundColor == "green") {
        carta.style.backgroundColor="#3498db"
        carta.style.color="transparent"
    } else {
        carta.style.backgroundColor="green"
        carta.style.color="black"
    }
}

function comprobarPares(carta1, carta2){
  if (carta1.textContent == carta2.textContent) {
    console.log(carta1.textContent + carta2.textContent)
    cartasVolteadas = [];
  } else{
    console.log(carta1.textContent + carta2.textContent)
    setTimeout(()=>{
      voltearCarta(carta1)
      voltearCarta(carta2)
      cartasVolteadas=[];
    },800)
    
  }
}


function iniciarTablero() {
  mezclarCartas(cartas);
  cartas.forEach((emoji, index) => {
    const carta = crearCarta(emoji, index);
    tablero.appendChild(carta);

    
    carta.addEventListener("click", ()=>{
        
        if (cartasVolteadas.length <2 ) {
          voltearCarta(carta)
          cartasVolteadas.push(carta)
        }
        if (cartasVolteadas.length == 2) {
          comprobarPares(cartasVolteadas[0], cartasVolteadas[1]);
        }
        
    })
  });
}






iniciarTablero();

