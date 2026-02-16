import pandas as pd
import matplotlib.pyplot as plt

#PARTE A

# Lista de productos
productos = []

#Estructura del producto
{
    "producto": "Teclado mecánico",
    "categoria": "Electrónica",
    "precio": 29.99,
    "stock": 45,
    "valoracion": 4.5,
    "proveedor": "LogiTech",
}


def mostrarMenu():
    """
    Muestra el menú principal de la aplicación en consola
    con todas las opciones disponibles.
    """
    print("\n--- MENÚ ---")
    print("1. Crear una lista de productos")
    print("2. Mostrar todos los productos")
    print("3. Añadir un nuevo producto")
    print("4. Buscar un producto por nombre")
    print("5. Calcular estadísticas")
    print("6. Filtrar por categoría")
    print("7. Generar top 3 por valoración")
    print("8. Opciones avanzadas")
    print("9. Salir")


def elegirOpcion():
    """
    Pide al usuario que elija una opción del menú
    y ejecuta la función correspondiente.
    """
    opcion = int(input("Elige una opción:"))
    match opcion:
        case 1:
            crearLista()
        case 2:
            mostrarTodo()
        case 3: 
            anadirProducto()
        case 4:
            buscarPorNombre()
        case 5:
            calcularEstadistica()
        case 6:
            filtrarCategoria()
        case 7:
            generarTopPorValoración()
        case 8:
            opcionesAvanzadas()
            
        case 9:
            print("¡Hasta luego! Vuelva pronto")
            exit()
        case _:
            print("Elija una opción válida")

def crearLista():
    """
    Crea una lista de productos de ejemplo y la guarda
    en la variable global 'productos'.
    """
    global productos
    productos = [
        {
            "producto": "Teclado mecánico",
            "categoria": "Electrónica",
            "precio": 29.99,
            "stock": 45,
            "valoracion": 4.5,
            "proveedor": "LogiTech",
        },
        {
            "producto": "Ratón inalámbrico",
            "categoria": "Electrónica",
            "precio": 19.99,
            "stock": 60,
            "valoracion": 4.3,
            "proveedor": "HP",
        },
        {
            "producto": "Monitor 24 pulgadas",
            "categoria": "Electrónica",
            "precio": 159.99,
            "stock": 15,
            "valoracion": 4.6,
            "proveedor": "Samsung",
        },
        {
            "producto": "Abrigo",
            "categoria": "Ropa",
            "precio": 79.99,
            "stock": 20,
            "valoracion": 4.2,
            "proveedor": "Zara",
        },
        {
            "producto": "Zapatillas deportivas",
            "categoria": "Ropa",
            "precio": 89.99,
            "stock": 30,
            "valoracion": 4.7,
            "proveedor": "Nike",
        },
        {
            "producto": "Mochila",
            "categoria": "Accesorios",
            "precio": 39.99,
            "stock": 25,
            "valoracion": 4.4,
            "proveedor": "Eastpak",
        }
    ]
    print("Lista de productos creada con datos de ejemplo")

def mostrarTodo():
    """
    Muestra todos los productos que existen actualmente
    en la lista 'productos'. Si no hay productos, muestra un mensaje.
    """
    if not productos:
        print("No hay productos")
        return
    for p in productos:
        print(p)

def anadirProducto():
    """
    Permite al usuario añadir un nuevo producto a la lista 'productos'.
    Pide al usuario todos los datos del producto y los guarda en un diccionario.
    Luego lo agrega a la lista global de productos.
    """
    if not productos:
        print("Crea primero la lista.")
        return
    
    try:
        nombre = input("Nombre del producto: ")
        categoria = input("Categoría: ")
        precio = float(input("Precio: "))
        stock = int(input("Stock: "))
        valoracion = float(input("Valoración: "))
        proveedor = input("Proveedor: ")

        nuevo = {
            "producto": nombre,
            "categoria": categoria,
            "precio": precio,
            "stock": stock,
            "valoracion": valoracion,
            "proveedor": proveedor
        }

        productos.append(nuevo)
        print("Producto añadido correctamente")
    except ValueError as e:
        print("Dato invalido",e)
    
    

def buscarPorNombre():

    if not productos:
        print("Crea primero la lista.")
        return

    try:
        nombre = input("Nombre del producto a buscar: ").lower()

        for p in productos:
            if p["producto"].lower() == nombre:
                print(p)
                return

        print("Producto no encontrado")
        
    except ValueError as e:
        print("Tipo de dato invalido: ",e)

def calcularEstadistica():

    if not productos:
        print("Crea primero la lista.")
        return

    precios = [p["precio"] for p in productos]
    valoraciones = [p["valoracion"] for p in productos]

    print(f"Precio medio: {sum(precios) / len(precios):.2f}")
    print(f"Precio máximo: {max(precios)}")
    print(f"Precio mínimo: {min(precios)}")
    print(f"Valoración media: {sum(valoraciones) / len(valoraciones):.2f}")


def filtrarCategoria():

    if not productos:
        print("Crea primero la lista.")
        return

    categoria = input("Introduce categoria: ").lower()
    filtrados = [p for p in productos if p["categoria"].lower() == categoria]

    if filtrados:
        for p in filtrados:
            print(p)
    else:
        print("No hay productos en esa categoria")


def generarTopPorValoración():

    if not productos:
        print("Crea primero la lista.")
        return
    
    top = sorted(productos, key=lambda x: x["valoracion"], reverse=True)[:3]

    print("Top 3 productos mejor valorados:")
    for p in top:
        print(p)


def exportarExcel(df):
    name = input("¿Con qué nombre quieres guardar el archivo?").lower()
    df.to_excel(name+".xlsx", index=False)  # Guardamos en Excel
    print(f"Lista de productos guardada en '{name}.xlsx'.")

def importarDesdeExcel():
    global productos
    try:
        name = input("¿Qué archivo quieres utiliza? (Si no quieres usar ninguno, pulsa ENTER)").lower()
        df = pd.read_excel(name+".xlsx")
        productos = df.to_dict(orient="records")
        print("Lista de productos cargada desde Excel.")
    except FileNotFoundError:
        print(f"No se encontró el archivo '{name}.xlsx'. Se creará una lista nueva cuando uses la opción 1.")

#PARTE B

def opcionesAvanzadas():
    if not productos:
        print("No hay productos cargados.")
        return

    df = pd.DataFrame(productos)

    while True:
        print("\n--- OPCIONES AVANZADAS ---")
        print("1. Mostrar tabla de datos")
        print("2. Añadir columna valor del stock")
        print("3. Añadir columna calidad")
        print("4. Filtrar por categoría")
        print("5. Agrupar por categoría")
        print("6. Filtrar productos +50 euros")
        print("7. Gráfico de barras")
        print("8. Gráfico de líneas")
        print("9. Gráfico circular")
        print("10. Exportar resultados a Excel")
        print("11. Volver al menú principal")

        opcion = input("Elige una opción: ")

        match opcion:
            case "1":
                print(df)
            case "2":
                df = anadirColumnaValorStock(df)
                print(df)

            case "3":
                df = anadirColumnaCalidad(df)
                print(df)

            case "4":
                filtrarPorCategoriaDf(df)

            case "5":
                agrupacionPorCategoria(df)

            case "6":
                filtroPorPrecio(df)

            case "7":
                graficoBarras(df)

            case "8":
                graficoLineas(df)

            case "9":
                graficoPastel(df)

            case "10":
                exportarExcel(df)

            case "11":
                estasSeguro(df)
                break
            case _:
                print("Opción no válida")


def anadirColumnaValorStock(df):
    df["valor_stock"] = df["precio"] * df["stock"]
    print("Columna añadida")
    return df

def anadirColumnaCalidad(df):
    df["calidad"] = df["valoracion"].apply(calcularCalidad)
    print("Columna añadida")
    return df

def calcularCalidad(valor):
    if valor >= 4.5:
        return "Alta"
    elif valor >= 4.0:
        return "Media"
    else:
        return "Baja"

def estasSeguro(df):
    respuesta = input("¿Deseas exportar tus datos antes de salir?(s/n)")
    if respuesta.lower()=="s":
        exportarExcel(df)
    else:
        pass

def filtrarPorCategoriaDf(df):
    categoria = input("Introduce la categoría a filtrar: ")
    filtrado = df[df["categoria"].str.lower() == categoria.lower()]
    if filtrado.empty:
        print("No se encontraron productos en esa categoría.")
    else:
        print(filtrado)
    
# Muestra el total de precio y stock agrupados por categoría
def agrupacionPorCategoria(df):
    agrupado = df.groupby("categoria")[["precio", "stock"]].sum()
    print("Total por categoría:")
    print(agrupado)

def filtroPorPrecio(df):
    filtrado = df[df["precio"] >50.00]
    print("Productos +50 euros:")
    print(filtrado)


def graficoBarras(df):
    
    plt.figure(figsize=(10,5))
    plt.bar(df["producto"], df["valoracion"], color="skyblue")
    plt.title("Valoración de productos")
    plt.xlabel("Producto")
    plt.ylabel("Valoración")
    plt.xticks(rotation=45)
    plt.grid(True)
    plt.show()


def graficoLineas(df):
    plt.figure(figsize=(10,5))
    plt.plot(df["producto"], df["stock"], marker='o', linestyle='-', color='green')
    plt.title("Stock de productos")
    plt.xlabel("Producto")
    plt.ylabel("Stock")
    plt.xticks(rotation=45)
    plt.grid(True)
    plt.show()

def graficoPastel(df):
    # Contar cuántos productos hay por categoría reales del DataFrame
    conteo_categorias = df['categoria'].value_counts()

    plt.figure(figsize=(8,8))
    plt.pie(conteo_categorias, 
            labels=conteo_categorias.index, 
            autopct='%1.1f%%', 
            wedgeprops={'edgecolor': 'black'})  # borde negro para cada sector
    plt.title('Distribución de productos por categoría')
    plt.axis('equal')  # Para que el pastel sea un círculo perfecto
    plt.show()

#INICIADOR DE APP
def iniciarApp():
    while True:
        mostrarMenu()
        elegirOpcion()

def main():
    importarDesdeExcel()
    iniciarApp()


if __name__ == '__main__':
    main()