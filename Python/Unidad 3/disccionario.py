#Crear diccionario
alumnos = [
    {"nombre":"Nico","edad":20,"hobbie":"Futbol","color_fav":"Rojo","serie_fav":"Stranger Things"},
    {"nombre":"Sara","edad":20,"hobbie":"Leer","color_fav":"Rojo","serie_fav":"One Piece"},
    {"nombre":"Patri","edad":19,"hobbie":"Escuchar musica","color_fav":"Morado","serie_fav":"Attack on titans"},
    {"nombre":"Ainoha","edad":19,"hobbie":"Escuchar musica","color_fav":"Azul","serie_fav":"Breaking Bad"},
    {"nombre":"Javier","edad":21,"hobbie":"Videojuegos","color_fav":"Rojo","serie_fav":"The walking dead"},
    {"nombre":"Xinbo","edad":19,"hobbie":"Dibujar","color_fav":"Azul","serie_fav":"Sao"},
    {"nombre":"Guillermo","edad":20,"hobbie":"Perder dinero en maggic","color_fav":"Rojo","serie_fav":"Arcane"},
    {"nombre":"Daniel","edad":23,"hobbie":"Salir","color_fav":"Morado","serie_fav":"Shameless"},
    {"nombre":"Sahif","edad":19,"hobbie":"Futbol sala","color_fav":"Azul","serie_fav":"Bojack Housserman"},
    {"nombre":"Xinlei","edad":20,"hobbie":"Fotografía","color_fav":"Negro","serie_fav":"Doraemon"}
]

#Imprimir en modo informe
print("Informe de alumnos")
for a in alumnos:
    print(a["nombre"] + ",", a["edad"], "años:")
    print("Hobbie: ", a["hobbie"])
    print("Color favorito: ", a["color_fav"])
    print("Serie favorita: ", a["serie_fav"])
    print("------------------------------------")

# Calcular media de un campo
sumaEdad=0
cantidadAlumnos = len(alumnos)

for a in alumnos:
    sumaEdad+=a["edad"]
print("La media de edad es:",int(sumaEdad/cantidadAlumnos))
print("------------------------------------")

# Calcular la moda de un campo
colores=[a["color_fav"] for a in alumnos]

moda = max(colores, key=colores.count)
print("El color mas común (moda) es:",moda)
print("------------------------------------")


# Calcular maximo / minimo de un campo y quien es
edades = []
alumnosEdadMin=[]
alumnosEdadMax=[]

for a in alumnos:
    edades.append(a["edad"])

edadMin = min(edades)
edadMax = max(edades)

for a in alumnos:
    if a["edad"] == edadMin:
        alumnosEdadMin.append(a["nombre"])
    if a["edad"]==edadMax:
        alumnosEdadMax.append(a["nombre"])

print("La edad minima es:",edadMin)
print(alumnosEdadMin)
print("La edad maxima es:",edadMax)
print(alumnosEdadMax)

print("------------------------------------")

# Filtrar segun valor de un campo
valor = 20
resultado = []
for a in alumnos:
    if a["edad"] == valor:
        resultado.append(a["nombre"])
print("Los alumnos de",valor,"años son:")
print(resultado)