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
    opcion = int(input("Elige una opción: "))
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
    """
    Busca un producto en la lista 'productos' según el nombre ingresado por el usuario.
    """
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
        print("Tipo de dato invalido: ", e)

def calcularEstadistica():
    """
    Calcula y muestra estadísticas básicas sobre los productos:
    precio medio, máximo y mínimo, y valoración media.
    """
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
    """
    Pide una categoría al usuario y muestra todos los productos que pertenecen a esa categoría.
    """
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
    """
    Muestra los 3 productos con mejor valoración de la lista.
    """
    if not productos:
        print("Crea primero la lista.")
        return
    
    top = sorted(productos, key=lambda x: x["valoracion"], reverse=True)[:3]

    print("Top 3 productos mejor valorados:")
    for p in top:
        print(p)

def exportarExcel():
    """
    Exporta la lista 'productos' a un archivo Excel.
    Pide al usuario el nombre del archivo.
    """
    if not productos:
        print("No hay productos para guardar.")
        return
    
    name = input("¿Con qué nombre quieres guardar el archivo?").lower()
    df = pd.DataFrame(productos)  # Convierte la lista en DataFrame para exportar fácilmente
    df.to_excel(name+".xlsx", index=False)  # Guarda sin índice en el archivo Excel
    print(f"Lista de productos guardada en '{name}.xlsx'.")


def importarDesdeExcel():
    """
    Carga productos desde un archivo Excel seleccionado por el usuario.
    Si el archivo no existe, informa y la lista seguirá vacía hasta crear una nueva.
    """
    global productos
    try:
        name = input("¿Qué archivo quieres utiliza? (Si no quieres usar ninguno, pulsa ENTER)").lower()
        df = pd.read_excel(name+".xlsx")
        productos = df.to_dict(orient="records")  # Convierte DataFrame a lista de diccionarios
        print("Lista de productos cargada desde Excel.")
    except FileNotFoundError:
        print(f"No se encontró el archivo '{name}.xlsx'. Se creará una lista nueva cuando uses la opción 1.")


#PARTE B: Opciones avanzadas usando pandas y matplotlib

def opcionesAvanzadas():
    """
    Muestra un menú con opciones avanzadas para manejar los productos con pandas
    """
    if not productos:
        print("No hay productos cargados.")
        return

    df = pd.DataFrame(productos)  # Creamos DataFrame desde la lista de productos

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
                print(df)  # Mostrar DataFrame completo
            case "2":
                df = anadirColumnaValorStock(df)  # Añade columna con valor total del stock
                print(df)
            case "3":
                df = anadirColumnaCalidad(df)  # Añade columna calidad según valoración
                print(df)
            case "4":
                filtrarPorCategoriaDf(df)  # Filtra por categoría 
            case "5":
                agrupacionPorCategoria(df)  # Muestra suma de precio y stock por categoría
            case "6":
                filtroPorPrecio(df)  # Muestra productos con precio > 50
            case "7":
                graficoBarras(df)  # Muestra gráfico de barras con valoración
            case "8":
                graficoLineas(df)  # Muestra gráfico de líneas con stock
            case "9":
                graficoPastel(df)  # Muestra gráfico circular de categorías
            case "10":
                exportarExcel()  # Exporta lista a Excel
            case "11":
                estasSeguro()  # Pregunta si quiere exportar antes de salir
                break
            case _:
                print("Opción no válida")

def anadirColumnaValorStock(df):
    """
    Añade una nueva columna 'valor_stock' calculando precio * stock.
    """
    df["valor_stock"] = df["precio"] * df["stock"]
    print("Columna añadida")
    return df

def anadirColumnaCalidad(df):
    """
    Añade una columna 'calidad' basada en la valoración numérica.
    """
    df["calidad"] = df["valoracion"].apply(calcularCalidad)
    print("Columna añadida")
    return df

def calcularCalidad(valor):
    """
    Clasifica la calidad en 'Alta', 'Media' o 'Baja' según la valoración.
    """
    if valor >= 4.5:
        return "Alta"
    elif valor >= 4.0:
        return "Media"
    else:
        return "Baja"

def estasSeguro():
    """
    Pregunta al usuario si desea exportar los datos antes de salir.
    """
    respuesta = input("¿Deseas exportar tus datos antes de salir?(s/n)")
    if respuesta.lower() == "s":
        exportarExcel()

def filtrarPorCategoriaDf(df):
    """
    Filtra y muestra productos de una categoría ingresada por el usuario (usando pandas).
    """
    categoria = input("Introduce la categoría a filtrar: ")
    filtrado = df[df["categoria"].str.lower() == categoria.lower()]
    if filtrado.empty:
        print("No se encontraron productos en esa categoría.")
    else:
        print(filtrado)

def agrupacionPorCategoria(df):
    """
    Agrupa los productos por categoría y muestra la suma de precio y stock por grupo.
    """
    agrupado = df.groupby("categoria")[["precio", "stock"]].sum()
    print("Total por categoría:")
    print(agrupado)

def filtroPorPrecio(df):
    """
    Muestra productos cuyo precio es mayor a 50 euros.
    """
    filtrado = df[df["precio"] > 50.00]
    print("Productos +50 euros:")
    print(filtrado)

def graficoBarras(df):
    """
    Muestra un gráfico de barras con la valoración de cada producto.
    """
    plt.figure(figsize=(10,5))
    plt.bar(df["producto"], df["valoracion"], color="skyblue")
    plt.title("Valoración de productos")
    plt.xlabel("Producto")
    plt.ylabel("Valoración")
    plt.xticks(rotation=45)
    plt.grid(True)
    plt.show()

def graficoLineas(df):
    """
    Muestra un gráfico de líneas con el stock de cada producto.
    """
    plt.figure(figsize=(10,5))
    plt.plot(df["producto"], df["stock"], marker='o', linestyle='-', color='green')
    plt.title("Stock de productos")
    plt.xlabel("Producto")
    plt.ylabel("Stock")
    plt.xticks(rotation=45)
    plt.grid(True)
    plt.show()

def graficoPastel(df):
    """
    Muestra un gráfico circular que representa la distribución de productos por categoría.
    """
    conteo_categorias = df['categoria'].value_counts()

    plt.figure(figsize=(8,8))
    plt.pie(conteo_categorias, 
            labels=conteo_categorias.index, 
            autopct='%1.1f%%', #Da formato a los decimales
            wedgeprops={'edgecolor': 'black'})  # Añade borde negro a sectores
    plt.title('Distribución de productos por categoría')
    plt.axis('equal')  # Para que el gráfico sea un círculo perfecto
    plt.show()

#INICIADOR DE APP
def iniciarApp():
    """
    Bucle infinito para mostrar el menú principal y elegir opciones.
    """
    while True:
        mostrarMenu()
        elegirOpcion()

def main():
    """
    Función principal que carga productos desde Excel y lanza la app.
    """
    importarDesdeExcel()
    iniciarApp()

if __name__ == '__main__':
    main()
