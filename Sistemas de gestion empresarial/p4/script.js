function cambiarColorFondo(){
    let titulo = document.getElementsByTagName("h1")[0]
    titulo.style.backgroundColor="white"
    titulo.style.color="red"
}

function cambiarContenido(){
    let parrafo = document.getElementById("parrafo")
    parrafo.textContent="Parrafo cambiado"
}

function cambiarImagen(){
    let imagen = document.getElementById("imagen")
    imagen.src="https://preview.redd.it/anyone-else-prefer-night-city-during-the-day-v0-nlmwljmcos3c1.jpg?width=640&crop=smart&auto=webp&s=8949040e6d6391eccde929a11db3d5bc7d2ff390"
}