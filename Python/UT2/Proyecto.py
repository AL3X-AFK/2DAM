import random

def iniciarSimulacion():
    cuentas = {
    "ES123412": {"titular": "Nico","password": "1234", "saldo": 500},
    "ES456432": {"titular": "Ana","password": "1111", "saldo": 1000}
    }
    mostrarMenuLoggin(cuentas)

def iniciarSesion(cuentas):
    titular = input("Introduce el nombre del titular: ")
    password = input("introduce la contraseña: ")
    for cuentaBancaria, datos in cuentas.items():
        if datos["titular"]==titular and datos["password"]==password:
            print(f"🪪 Bienvenido {titular}, tu numero de cuenta es {cuentaBancaria}")
            mostrarMenu(cuentas,cuentaBancaria)
            return
    else:
        print("❌ Usuario o contraseña incorrectos.")


def registro(cuentas):
    try:
        titular = input("Introduce el nombre del titular: ")
        for cuentaBancaria, datos in cuentas.items():
            if datos["titular"]==titular:
                print("🚫 Usuario existente. Intente con otro nombre")
                return
        password = input("Introduce la contraseña: ")
        saldo = float(input("Introduce el saldo inicial: "))
        cuentaBancaria = generarNumBancario(cuentas) 
        cuentas[cuentaBancaria]={
            "titular":titular,
            "password":password,
            "saldo":saldo
        }
        print(f"✅ Registro completado con exito.\n🪪 Bienvenido {titular}! Su numero de cuenta es {cuentaBancaria}")
        mostrarMenu(cuentas,cuentaBancaria)
    except ValueError:
        print("❌ El saldo debe ser un número válido.")

def generarNumBancario(cuentas):
    while True:
        numBancario = str(random.randint(100000,999999))
        cuenta = "ES"+numBancario
        if cuenta not in cuentas:
            return cuenta

def mostrarMenuLoggin(cuentas):
    while True:
        try:
            optionInicial = int(input("🏦 BIENVENIDO A TU BANCO DE CONFIANZA 🏦\n1.🔑 Iniciar sesión\n2.📝 Registrarse\n3.🚪 Salir\n"))
            if optionInicial==1:
                iniciarSesion(cuentas)
            elif optionInicial==2:        
                registro(cuentas)
            elif optionInicial==3:
                print("👋 Saliendo...")
                break
            else:
               print("🚫 Opción no válida.")
        except ValueError:
            print("🚫 Introduce un valor válido.")

def mostrarMenu(cuentas,cuentaBancaria):
    while True:
        try:
            opcion = int(input(f"🏧 Menu para {cuentas[cuentaBancaria]["titular"]}\n1.💵 Ingresar dinero\n2.💸 Retirar dinero\n3.💰 Ver saldo\n4.👤 Ver información personal\n5.📤 Realizar transferencia\n6.📥 Pedir préstamo\n7.🚪 Salir\n"))
            match opcion:
                case 1:
                    ingresarDinero(cuentas, cuentaBancaria)
                case 2:
                    retirarDinero(cuentas, cuentaBancaria)
                case 3:
                    verSaldo(cuentas, cuentaBancaria)
                case 4:
                    verInfoPersonal(cuentas, cuentaBancaria)
                case 5:
                    realizarTransferencia(cuentas,cuentaBancaria)
                case 6:
                    pedirPrestamo(cuentas,cuentaBancaria)
                case 7:
                    print(f"👋 ¡Hasta pronto, {cuentas[cuentaBancaria]["titular"]}!")
                    break
                case _:
                    print("🚫 Introduce una opcion correcta.")
        except ValueError:
            print("🚫 Introduce una opcion correcta.")
def ingresarDinero(cuentas, cuentaBancaria):
    while True:
        try:
            saldoAIngresar = float(input("¿Cuanto dinero quieres ingresar a la cuenta?\n"))
            if saldoAIngresar < 0:
                print("🚫 Ingresa una cantidad positiva")
                continue

        except ValueError:
            print("🚫 Ingrese un dato válido")
        else:
            cuentas[cuentaBancaria]["saldo"] += saldoAIngresar
            print("✅ Dinero ingresa con EXITO")
            break

def retirarDinero(cuentas, cuentaBancaria):
    while True:
        try:
            saldoARetirar = float(input("¿Cuanto dinero quieres retirar de la cuenta?\n"))

            if saldoARetirar < 0:
                print("🚫 Ingresa una cantidad positiva")
                continue

            if saldoARetirar > cuentas[cuentaBancaria]["saldo"]:
                print("🚫 No tienes suficiente saldo en tu cuenta")
                verSaldo(cuentas, cuentaBancaria)
                continue

        except ValueError:
            print("🚫 Ingrese un dato válido")
        else:
            cuentas[cuentaBancaria]["saldo"] -= saldoARetirar
            print("✅ Dinero retirado con EXITO")
            break


def verSaldo(cuentas, cuentaBancaria):
    print("💰 Tu saldo actual es de: $",cuentas[cuentaBancaria]["saldo"])

def verInfoPersonal(cuentas,cuentaBancaria):
    print(f"\n💳 Número de cuenta bancaria: {cuentaBancaria}\n👤 Nombre de usuario: {cuentas[cuentaBancaria]['titular']}\n🔒 Contraseña: {cuentas[cuentaBancaria]['password']}\n💰 Saldo disponible: $ {cuentas[cuentaBancaria]["saldo"]}")

def realizarTransferencia(cuentas,cuentaBancaria):
    while True:
        try:
            usuarioTransferencia = input("Introduce la cuenta bancaria del usuario al que desea transferir el dinero (Enter para cancelar): ")
            if usuarioTransferencia == "":
                print("↩️ Transferencia cancelada.")
                break
            dineroTransferido = float(input("Introduce la cantidad que desea transferir: "))
            if dineroTransferido < 0:
                print("🚫 Ingresa una cantidad positiva")
                continue
            if dineroTransferido > cuentas[cuentaBancaria]["saldo"]:
                print("❌ No tienes suficiente saldo en tu cuenta")
                verSaldo(cuentas, cuentaBancaria)
                continue
        except ValueError:
            print("❌ Cantidad ingresada no válida.")
            break
        if usuarioTransferencia == cuentaBancaria:
                print("🚫 No puedes transferirte dinero a ti mismo.")
                continue
        if usuarioTransferencia in cuentas:
            cuentas[usuarioTransferencia]['saldo'] += dineroTransferido
            cuentas[cuentaBancaria]['saldo'] -= dineroTransferido
            print(f"✅ ¡Transferencia realizada! ${dineroTransferido} a {cuentas[usuarioTransferencia]['titular']}")
            break
        else:
            print("❌ ¡Fallo en la transferencia! Usuario no encontrado.")
            break
def verHistorial():
    pass

iniciarSimulacion()