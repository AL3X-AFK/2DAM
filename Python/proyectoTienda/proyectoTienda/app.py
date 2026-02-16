from inventario import Inventario

class App:

    def __init__(self):
        self.inventario = Inventario()

    """
    Muestra el menú principal de la aplicación en consola
    con todas las opciones disponibles.
    """
    def mostrarMenu(self):
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

    """
    Pide al usuario que elija una opción del menú
    y ejecuta la función correspondiente.
    """
    def elegirOpcion(self):

        try:
            opcion = int(input("Elige una opción:"))
        except ValueError:
            print("Opción inválida")
            return

        match opcion:
            case 1:
                self.inventario.crearLista()
            case 2:
                self.inventario.mostrarTodo()
            case 3:
                self.inventario.anadirProducto()
            case 4:
                self.inventario.buscarPorNombre()
            case 5:
                self.inventario.calcularEstadistica()
            case 6:
                self.inventario.filtrarCategoria()
            case 7:
                self.inventario.generarTopPorValoración()
            case 8:
                self.inventario.opcionesAvanzadas()
            case 9:
                print("¡Hasta luego! Vuelva pronto")
                exit()
            case _:
                print("Opción no válida")

    def iniciarApp(self):
        while True:
            self.mostrarMenu()
            self.elegirOpcion()