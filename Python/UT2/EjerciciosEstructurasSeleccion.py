# 1 Pedir un número y mostrar si es positivo o negativo.
num = int(input("Ingresa un numero: "))
if num > 0:
    print("Es positivo")
else:
    print("Es negativo")

# 2 Pedir un número y mostrar si es par o impar.
num = int(input("Ingresa un numero: "))
if num % 2 == 0:
    print("Es Par")
else:
    print("Es Impar")

# 3 Pedir la edad y mostrar si la persona es mayor de edad (≥18) o no.
num = int(input("Ingresa la edad: "))
if num >= 18:
    print("Es Mayor de edad")
else:
    print("Es Menor de edad")

# 4 Pedir una contraseña y comprobar si coincide con la guardada en una variable.
password = "gorila"
intento = input("Ingresa la contraseña: ")
if intento == password:
    print("Contraseña correca")
else:
    print("Contraseña incorrecta")

# 5 Pedir una nota numérica y mostrar si el alumno aprueba (≥5) o suspende (<5).
num = int(input("Ingresa la nota numerica: "))
if num >= 5 and num <=10:
    print("Aprobado")
elif num >= 0 and num < 5:
    print("Suspenso")
else:
    print("Nota invalida")

# 6 Pedir un número y mostrar si es múltiplo de 3.
num = int(input("Ingresa un numero: "))
if num % 3 == 0:
    print("Es Multiplo de tres")
else:
    print("No es Multiplo de tres")

# 7 Pedir dos números y mostrar cuál es mayor (o si son iguales).
num1 = int(input("Ingresa un numero: "))
num2 = int(input("Ingresa otro numero: "))
if num1 == num2:
    print("Son iguales")
elif num1 > num2:
    print(num1,"es mayor a",num2)
else:
    print(num2,"es mayor a",num1)    

# 8 Nota 0–4 → suspenso, 5–6 → aprobado, 7–8 → notable, 9–10 → sobresaliente.
num = int(input("Ingresa la nota: "))
if num >= 0 and num <=4:
    print("Suspenso")
elif num >= 5 and num <= 6:
    print("Aprovado")
elif num >= 7 and num <= 8:
    print("Notable")
elif num >= 9 and num < 10:
    print("Sobresaliente")
else:
    print("Nota invalida")

# 9 Pedir un número del 1 al 7 y mostrar qué día corresponde (1 = lunes…).
num = int(input("Ingresa un numero del 1 al 7: "))
match num:
    case 1:
        print("Lunes")
    case 2:
        print("Martes")
    case 3:
        print("Miercoles")
    case 4:
        print("Jueves")
    case 5:
        print("Viernes")
    case 6:
        print("Sabado")
    case 7:
        print("Domingo")
    case _:
        print("Error")


# 10 Pedir dos números y una operación (+, -, *, /) y mostrar el resultado.
num1 = float(input("Ingresa un numero: "))
num2 = float(input("Ingresa otro  numero: "))
operacion = input("Ingresa una operacion: +, -, *, /: ")
match operacion:
    case '+':
        print (num1 + num2)
    case '-':
        print (num1 - num2)
    case '*':
        print (num1 * num2)
    case '/':
        print (num1 / num2)
    case _:
        print ("Error")

# 11 Pedir edad y si tiene carnet (True/False) y mostrar si puede conducir.
edad = int(input("Ingresa la edad: "))
carnet = input("Tiene carnet (True/False): ")
if edad >= 18 and carnet == "True":
    print("Puede conducir")
else:
    print("No puede consucir")

# 12 Pedir un número y mostrar si está entre 1 y 100.
num = int(input("Ingresa un numero: "))
match num:
    case n if 1<= n <=100:
        print("Esta entre 1 y 100")
    case _:
        print("Esta fuera del rango")

# 13 Pedir tres notas y mostrar si el alumno aprueba (media ≥5 y ninguna <3).
nota1 = int(input("Nota 1: "))
nota2 = int(input("Nota 2: "))
nota3 = int(input("Nota 3: "))
media = (nota1 + nota2 + nota3)/3
if media >= 5 and media <=10:
    print("Aprobado")
elif media >= 0 and media < 5:
    print("Suspenso")
else:
    print("Nota invalida")

# 14 Pedir tres lados y mostrar si el triángulo es equilátero, isósceles o escaleno.
lado1 = int(input("Lado 1: "))
lado2 = int(input("Lado 2: "))
lado3 = int(input("Lado 3: "))
if lado1 == lado2 == lado3:
    print("Triangulo equilatero ")
elif lado1 == lado2 or lado2 == lado3 or lado1 == lado3:
    print("Triangulo isoceles")
else:
    print("Triangulo escaleno")

# 15 Pedir un año y determinar si es bisiesto.
year = int(input("Ingresa un año: "))
if year % 4 == 0:
    if year %100 != 0 or year %400 == 0:
        print("Año bisiesto")
else: 
    print("No es bisiesto")

# 16 El usuario elige una opción, el ordenador otra (usar random) y se indica quién gana.
import random
opcion = input("Escoge(piedra, papel o tijera): ")
random = random.randrange(0 , 3)
maquina = ""
match random:
    case 0:
        maquina = "piedra"
    case 1: 
        maquina = "papel"
    case 2:
        maquina = "tijera"
if (opcion == "piedra" and maquina == "tijera") or (opcion == "papel" and maquina == "piedra") or (opcion == "tijera" and maquina == "piedra") :
    print("Has ganado")
elif opcion == maquina:
    print("Empate")
else:
    print("Has perdido")

# 17 Pide al usuario el precio de un producto y su edad. Si el usuario es menor de 18 años → 10% de descuento. Si es mayor o igual a 65 años → 20% de descuento. En otro caso, no hay descuento. Muestra el precio final.
precio = float(input("Ingresa el precio: "))
edad = int(input("Ingresa la edad: "))
precioFinal = precio
match edad:
    case e if e < 18:
        precioFinal = precio - (precio * 0.1)
    case e if e >= 65:
        precioFinal = precio - (precio * 0.2)
print (precioFinal)

# 18 Pide al usuario una temperatura y la unidad (C o F). Si la unidad es C, conviértela a Fahrenheit con la fórmula: F = C * 9/5 + 32. Si la unidad es F, conviértela a Celsius con la fórmula: C = (F - 32) * 5/9. Si la unidad no es válida, mostrar un mensaje de error.
temp = float(input("Ingresa la temperatura: "))
unidad = input("Ingresa la unidad (C o F): ")
match unidad:
    case "C":
        temp = temp * 9/5 + 32
        print(temp, "en F")
    case "F":
        temp = (temp - 32) * 5/9
        print(temp, "en C")
    case _:
        print("Error")
