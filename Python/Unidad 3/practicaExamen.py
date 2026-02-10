from pprint import pprint
import pandas as pd
import matplotlib.pyplot as plt
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



def main():
    df = pd.read_excel('productos.xlsx')
    print(df.shape)

if __name__ == "__main__":
    main()


'''
def a1():
    for i in alumnos:
        print(i["nombre"],"tiene", i["edad"],"años")

def f1():
    name = input("ingresa el nombre: ")
    for i in alumnos:
        if name == i["nombre"]:
            print("Encontrado:", i["nombre"])
            break
    else:
        print("No existe")


def f2():
    colores = {}
    for i in alumnos:
        color = i["color_fav"]
        if color in colores:
            colores[color] +=1
        else:
            colores[color] = 1
    print(colores)

def f3():
    aux = {}
    for i in alumnos:
        clave = i["nombre"]
        aux[clave] = i
    pprint(aux)


def f4():
    aux = []
    color = "Rojo"
    for i in alumnos:
        if i["color_fav"] == color:
            salida = {"color":i["color_fav"],"edad":i["edad"]}
            aux.append(salida)
    total = len(aux)
    suma = 0
    for i in aux:
        suma += i["edad"]
    print("La edad media del color",color,"es:",suma/total)



def f5():
    ordenEdad = sorted(alumnos, key= lambda alumnos: alumnos["edad"])
    pprint(ordenEdad)

def f6():
    edades = {"+20":0,"-20":0}
    for i in alumnos:
        if i["edad"] >=20:
            edades["+20"]+=1
        else:
            edades["-20"]+=1
    pprint(edades)


def f7():
    num = int(input("Ingresa un num: "))
    ordenEdad = sorted(alumnos, key=lambda alumnos:alumnos["edad"])
    pprint(ordenEdad[:num])


#Pandas y matplotlib
df = pd.read_excel('productos.xlsx')

def printdf():
    print(df)

def f8():
    df["Multi"] = df['precio'] * df['stock']
    print(df)

def prom():
    df['Prom'] = df[['precio','stock','valoracion']].mean(axis=1)
    print(df)

def f9():
    df["Mas4stars"] = df["valoracion"]>=4
    print(df)

def nuevaFila():
    nueva ={
        "producto":"PC",
        "categoria":"OMG",
        "precio":300,
        "valoracion":5,
        "proveedor":"LG"
    }
    df.loc[len(df)] = nueva
    print(df)

def borrarFila():
    df.drop(len(df)-1, inplace=True)
    print(df)



def grafico():
    plt.bar(df["producto"], df["precio"])
    plt.show()

if __name__ == '__main__':
    grafico()
    '''