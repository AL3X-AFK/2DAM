banco = {
    "123": {"titular": "Nicolás","password": "1234", "saldo": 500},
    "456": {"titular": "Ana","password": "1111", "saldo": 1000}
}


def iniciarSimulacion():
    print("1. Iniciar sesión\n2. Registrarse:\n")

def iniciarSesion():
    pass

def Registro():
    pass
    
def mostrarMenu():
    opcion = int(input("1. Retinar dinero\n2. Ingresar dinero\n3. Ver saldo\n4. Realizar Transferencia(en proceso)\n 5. Pedir Prestamo\n 6. Ver Historial\n7. Salir\n"))
    match opcion:
        case 1: retirarDinero()
        case 2: ingresarDinero()
        case 3: verSaldo()
        case 4: realizarTransferencia()
        case 5: pedirPrestamo()
        case 6: verHistorial()
        case 7: salir()
    
def retirarDinero():
    cantidadARetirar = input("Ingresa la cantidad que deseas retirar: \n")

    
def ingresarDinero():
    pass
    
def verSaldo():
    pass
    
def realizarTransferencia():
    pass
    
def pedirPrestamo():
    pass

def verHistorial():
    pass

def salir():
    pass