from app import App

def main():
    app = App()
    app.inventario.importarDesdeExcel()
    app.iniciarApp()

if __name__ == '__main__':
    main()