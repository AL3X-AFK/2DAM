from pprint import pprint
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
    {"nombre":"Sahif","edad":18,"hobbie":"Futbol sala","color_fav":"Azul","serie_fav":"Bojack Housserman"},
    {"nombre":"Xinlei","edad":20,"hobbie":"Fotografía","color_fav":"Negro","serie_fav":"Doraemon"}
]

#Ejercicio 1
def ejercicio1():
    for i in alumnos:
        print(i["nombre"])

#Ejercicio 2
def ejercicio2():
    for i in alumnos:
        print(f"{i["nombre"]} tiene {i["edad"]} años")

#Ejercicio 3
def ejercicio3():
    nombre = input("Ingresa un nombre a buscar: ")
    encontrado = False

    for i in alumnos:
        if nombre == i["nombre"]:
            encontrado = True
            print(f"{i["nombre"]} - {i["edad"]} - {i["hobbie"]} - {i["color_fav"]} - {i["serie_fav"]}") 
            break

    if not encontrado:
            print("Usuario no encontrado...")    
    
#Ejercicio 4
def ejercicio4():
    sumaDeEdades = 0
    for i in alumnos:
        sumaDeEdades += i["edad"]
    print(f"La media de las edades es: {int(sumaDeEdades / len(alumnos))}")


#Ejercicio 5
def ejercicio5():
    mayor = alumnos[0]
    menor = alumnos[0]
    for i in alumnos:
        if i["edad"] > mayor["edad"]:
            mayor = i
        if i["edad"] < menor["edad"]:
            menor = i
    print(f"El alumno con mas edad es: {mayor["nombre"]} con {mayor["edad"]} años")
    print(f"El alumno con menos edad es: {menor["nombre"]} con {menor["edad"]} años")


def ejercicio6():
    edad = int(input("Ingresa la edad limite: "))
    lista = []
    for i in alumnos:
        if i["edad"] > edad:
            lista.append(i)

    print("Los alumnos que superan esa edad son:")
    for i in lista:
        print(i["nombre"], i["edad"])


def ejercicio7():
    color = input("Ingresa el color a buscar: ")
    aux = []
    for i in alumnos:
        if color.lower() == i["color_fav"].lower():
            aux.append(i)
    
    print("Los alumnos con ese color son: ")
    for i in aux:
        print(f"{i["nombre"]} - {i["color_fav"]}")


def ejercicio8():
    aux = {}
    for i in alumnos:
        color = i["color_fav"]
        if color in aux:
            aux[color] += 1
        else:
            aux[color] = 1

    print(aux)


def ejercicio9():
    lista = []
    for i in alumnos:
        entrada = {"nombre":i["nombre"] , "edad":i["edad"]}
        lista.append(entrada)
    
    for i in lista:
        print(i)


def ejercicio10():
    dic = {}
    for i in alumnos:
        nombre = i["nombre"]
        dic[nombre] = i
    
    pprint(dic)


def ejercicio11():
    color = "Azul"
    auxDic = []
    for i in alumnos:
        if i["color_fav"] == color:
            entrada = {"nombre":i["nombre"] , "edad":i["edad"], "color":i["color_fav"]}
            auxDic.append(entrada)

    suma = 0
    total = len(auxDic)
    for i in auxDic:
        suma += int(i["edad"])
    print("La edad media de los alumnos a los que les gusta el ",color,"es:", suma/total)



if __name__ == '__main__':
    ejercicio11()