'''
#1. División segura. Pedir dos números e intentar dividirlos.
#Capturar división por cero (ZeroDivisionError).
#Mostrar el resultado si no hay error. 
try: 
    n1 = int(input("Ingresa el primer numero: "))
    n2 = int(input("Ingresa el segundo numero: "))
    resultado = n1/n2
except ZeroDivisionError:
    print("No se puede dividir para CERO")
else:
    print(f"El resultado es: {resultado}")
finally:
    print("Programa terminado")


#2. Entrada de enteros.
#Pedir un número entero y capturar el error si el usuario introduce texto (ValueError).
try:
    n1 = int(input("Ingresa un numero: "))
except ValueError:
    print("Tipo de dato incorrecto")
else:
    print("El numero es: ",n1)


# 3. Calculadora con control de errores. Pedir dos números y una operación (+,-, *, /). 
#Usar try/except para evitar errores de división por cero o entrada no numérica. 
#Mostrar un mensaje si la operación no es válida.
try: 
    n1 = int(input("Ingresa el primer valor: "))
    n2 = int(input("Ingresa el segun numero: "))
    c = input("Ingresa la operacion (+,-, *, /): ")
    resultado = 0
    match c:
        case '+': resultado = n1+n2
        case '-': resultado = n1-n2
        case '*': resultado = n1*n2
        case '/': resultado = n1/n2
except ZeroDivisionError:
    print("No se puede dividir por CERO")
except ValueError:
    print("Tipo de dato incorrecto")
else:
    print("Resultado: ", resultado)


# 4. Número par o impar con validación. Pedir un número entero.
#Si no es válido, capturar el error.
#Mostrar si el número es par o impar.
try:
    n = int(input("Ingresa el numero: "))
    
except ValueError:
    print("Error de tipo")
else:
    cantidad = 0
    mensaje =""
    for x in range(1, n+1):
        if n%x == 0:
            cantidad += 1
    if cantidad == 2:
        mensaje = "Es primo"
    else:
        mensaje = "No es primo"
    print(mensaje)


# 5. Pedir número hasta que sea válido.
#Repetir con while hasta que el usuario introduzca un número entero válido.
#Al final, mostrar el número correcto.
while(True):
    try:
        n = int(input("Ingresa un numero: "))
    except ValueError:
        print("Tipo de dato incorrecto, intentalo de nuevo")
    else:
        print("MUY BIEN")
        break;


# 6. Menú con control de excepciones. Mostrar un menú de opciones (1. Sumar, 2. Restar, 3. Salir).
#Capturar si el usuario introduce una opción no numérica o inválida.
#Ejecutar la opción hasta que elija salir.
while(True):
    try:
        print("1. Sumar")
        print("2. Restar")
        print("3. Salir")
        acciones = ["sumar", "restar", "salir"]
        opcion = int(input("Ingresa una opcion: "))
        accion = acciones[opcion-1]

    except ValueError:
        print("Tipo de dato incorrecto")
    except IndexError:
        print("Numero fuera de rango")
    else:
        match accion:
            case "sumar": print("Estas sumando")
            case "restar": print("Estas restando")
            case "salir": break


# 7.Conversor de temperaturas robusto. Pedir al usuario una temperatura y la unidad (C o F).
#Capturar errores de conversión de tipo.
#Validar la unidad con selección (if).
#Repetir hasta que se introduzcan datos válidos.
while(True):
    try:
        num = int(input("Ingresa la temperatura: "))
        unidad = input("Ingresa la unidad (C o F): ")
        unidad = unidad.upper()
    except ValueError:
        print("Error de tipo")
    else:
        if unidad == 'C':
            print("En ºF la temeratura es: ", (num*1.8+32),"ºF")
            break
        elif unidad == 'F':
            print("En ºC la temeratura es: ", (num-32/1.8),"ºC")
            break
        else:
            print("Unidad no valdia")


# 8. Juego del adivinador con errores. Generar un número aleatorio del 1 al 10.
#Pedir al usuario que adivine con un while.
#Capturar error si introduce algo que no sea un número (ValueError).
#Indicar con if si el número introducido es mayor o menor que el secreto.
import random
n = random.randint(1, 10)
print(n)
ganador = False
while(not ganador):
    try:
        usuario = int(input("Adivina el numero: "))
    except ValueError:
        print("Valor invalido")
    else:
        if usuario > n:
            print("El numero es menor")
        elif usuario < n:
            print("El numero es mayor")
        else:
            ganador = True
print("Juego terminado")
'''