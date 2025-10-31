var titulo = document.getElementsByTagName("h1")[0]
var p1 = document.getElementsByTagName("p")[0]
var imagen = document.getElementsByTagName("img")[0]

titulo.addEventListener("mouseover", cambiarColorFondo)
p1.addEventListener("click", cambiarContenido)
imagen.addEventListener("mouseleave", cambiarImagen)

function cambiarColorFondo(){

    if (titulo.style.backgroundColor=="white"){ 
        titulo.style.backgroundColor="rgb(212, 3, 3)"
        titulo.style.color="white"
    }else{ 
        titulo.style.backgroundColor="white"
        titulo.style.color="red"

    }
}

function cambiarContenido(){

    if (parrafo.textContent=="Parrafo cambiado" ) 
        parrafo.textContent="Estado original"
    else
        parrafo.textContent="Parrafo cambiado"
}

function cambiarImagen(){
    imagen.id="id_imagen"

    if (imagen.src=="https://preview.redd.it/anyone-else-prefer-night-city-during-the-day-v0-nlmwljmcos3c1.jpg?width=640&crop=smart&auto=webp&s=8949040e6d6391eccde929a11db3d5bc7d2ff390")
        imagen.src = "https://static.cdprojektred.com/cms.cdprojektred.com/16x9_big/872822c5e50dc71f345416098d29fc3ae5cd26c1-1280x720.jpg" 
    else
        imagen.src="https://preview.redd.it/anyone-else-prefer-night-city-during-the-day-v0-nlmwljmcos3c1.jpg?width=640&crop=smart&auto=webp&s=8949040e6d6391eccde929a11db3d5bc7d2ff390"
}




