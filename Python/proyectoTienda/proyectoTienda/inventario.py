from producto import Producto
import pandas as pd
import matplotlib.pyplot as plt

class Inventario:

    def __init__(self):
        # Lista de productos
        self.productos = []

    """
    Crea una lista de productos de ejemplo y la guarda
    en la variable 'self.productos'.
    """
    def crearLista(self):
        self.productos = [
            Producto("Teclado mecánico", "Electrónica", 29.99, 45, 4.5, "LogiTech"),
            Producto("Ratón inalámbrico", "Electrónica", 19.99, 60, 4.3, "HP"),
            Producto("Monitor 24 pulgadas", "Electrónica", 159.99, 15, 4.6, "Samsung"),
            Producto("Abrigo", "Ropa", 79.99, 20, 4.2, "Zara"),
            Producto("Zapatillas deportivas", "Ropa", 89.99, 30, 4.7, "Nike"),
            Producto("Mochila", "Accesorios", 39.99, 25, 4.4, "Eastpak")
        ]
        print("Lista de productos creada con datos de ejemplo")

    """
    Muestra todos los productos que existen actualmente
    en la lista 'self.productos'. Si no hay productos, muestra un mensaje.
    """
    def mostrarTodo(self):
        if not self.productos:
            print("No hay productos")
            return
        for p in self.productos:
            print(p.to_dict())

    """
    Permite al usuario añadir un nuevo producto a la lista 'self.productos'.
    """
    def anadirProducto(self):
        if not self.productos:
            print("Crea primero la lista.")
            return

        try:
            nombre = input("Nombre del producto: ")
            categoria = input("Categoría: ")
            precio = float(input("Precio: "))
            stock = int(input("Stock: "))
            valoracion = float(input("Valoración: "))
            proveedor = input("Proveedor: ")

            nuevo = Producto(nombre, categoria, precio, stock, valoracion, proveedor)
            self.productos.append(nuevo)

            print("Producto añadido correctamente")
        except ValueError as e:
            print("Dato invalido", e)

    def buscarPorNombre(self):

        if not self.productos:
            print("Crea primero la lista.")
            return

        nombre = input("Nombre del producto a buscar: ").lower()

        for p in self.productos:
            if p.producto.lower() == nombre:
                print(p.to_dict())
                return

        print("Producto no encontrado")

    def calcularEstadistica(self):

        if not self.productos:
            print("Crea primero la lista.")
            return

        precios = [p.precio for p in self.productos]
        valoraciones = [p.valoracion for p in self.productos]

        print(f"Precio medio: {sum(precios) / len(precios):.2f}")
        print(f"Precio máximo: {max(precios)}")
        print(f"Precio mínimo: {min(precios)}")
        print(f"Valoración media: {sum(valoraciones) / len(valoraciones):.2f}")

    def filtrarCategoria(self):

        if not self.productos:
            print("Crea primero la lista.")
            return

        categoria = input("Introduce categoria: ").lower()
        filtrados = [p for p in self.productos if p.categoria.lower() == categoria]

        if filtrados:
            for p in filtrados:
                print(p.to_dict())
        else:
            print("No hay productos en esa categoria")

    def generarTopPorValoración(self):

        if not self.productos:
            print("Crea primero la lista.")
            return

        top = sorted(self.productos, key=lambda x: x.valoracion, reverse=True)[:3]

        print("Top 3 productos mejor valorados:")
        for p in top:
            print(p.to_dict())

    def exportarExcel(self, df):
        name = input("¿Con qué nombre quieres guardar el archivo?").lower()
        df.to_excel(name + ".xlsx", index=False)
        print(f"Lista de productos guardada en '{name}.xlsx'.")

    def importarDesdeExcel(self):
        try:
            name = input("¿Qué archivo quieres utiliza? (Si no quieres usar ninguno, pulsa ENTER)").lower()
            if name == "":
                return
            df = pd.read_excel(name + ".xlsx")
            self.productos = [
                Producto(**fila) for fila in df.to_dict(orient="records")
            ]
            print("Lista de productos cargada desde Excel.")
        except FileNotFoundError:
            print(f"No se encontró el archivo '{name}.xlsx'.")

#PARTE B

    def opcionesAvanzadas(self):

        if not self.productos:
            print("No hay productos cargados.")
            return

        df = pd.DataFrame([p.to_dict() for p in self.productos])

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
                    df = self.anadirColumnaValorStock(df)
                    print(df)
                case "3":
                    df = self.anadirColumnaCalidad(df)
                    print(df)
                case "4":
                    self.filtrarPorCategoriaDf(df)
                case "5":
                    self.agrupacionPorCategoria(df)
                case "6":
                    self.filtroPorPrecio(df)
                case "7":
                    self.graficoBarras(df)
                case "8":
                    self.graficoLineas(df)
                case "9":
                    self.graficoPastel(df)
                case "10":
                    self.exportarExcel(df)
                case "11":
                    self.estasSeguro(df)
                    break
                case _:
                    print("Opción no válida")

    def anadirColumnaValorStock(self, df):
        df["valor_stock"] = df["precio"] * df["stock"]
        print("Columna añadida")
        return df

    def anadirColumnaCalidad(self, df):
        df["calidad"] = df["valoracion"].apply(self.calcularCalidad)
        print("Columna añadida")
        return df

    def calcularCalidad(self, valor):
        if valor >= 4.5:
            return "Alta"
        elif valor >= 4.0:
            return "Media"
        else:
            return "Baja"

    def estasSeguro(self, df):
        respuesta = input("¿Deseas exportar tus datos antes de salir?(s/n)")
        if respuesta.lower() == "s":
            self.exportarExcel(df)

    def filtrarPorCategoriaDf(self, df):
        categoria = input("Introduce la categoría a filtrar: ")
        filtrado = df[df["categoria"].str.lower() == categoria.lower()]
        if filtrado.empty:
            print("No se encontraron productos en esa categoría.")
        else:
            print(filtrado)

    def agrupacionPorCategoria(self, df):
        agrupado = df.groupby("categoria")[["precio", "stock"]].sum()
        print("Total por categoría:")
        print(agrupado)

    def filtroPorPrecio(self, df):
        filtrado = df[df["precio"] > 50.00]
        print("Productos +50 euros:")
        print(filtrado)

    def graficoBarras(self, df):
        plt.figure(figsize=(10,5))
        plt.bar(df["producto"], df["valoracion"], color="skyblue")
        plt.title("Valoración de productos")
        plt.xlabel("Producto")
        plt.ylabel("Valoración")
        plt.xticks(rotation=45)
        plt.grid(True)
        plt.show()

    def graficoLineas(self, df):
        plt.figure(figsize=(10,5))
        plt.plot(df["producto"], df["stock"], marker='o', linestyle='-', color='green')
        plt.title("Stock de productos")
        plt.xlabel("Producto")
        plt.ylabel("Stock")
        plt.xticks(rotation=45)
        plt.grid(True)
        plt.show()

    def graficoPastel(self, df):
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
