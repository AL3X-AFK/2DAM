# 1. Declara tres variables (nombre, edad, altura) con tu información personal y muéstralas por pantalla en una frase.
nombre = "Alex"
edad = 21
altura = 1.78
print(f"Hola, mi nombre es {nombre}, tengo {edad} años y mido {altura} cm")

#2. Crea una constante PI = 3.1416 y calcula el perímetro de un círculo de radio 5.
PI = 3.1416
radio = 5
perimetro = 2 * PI * radio
print(f"El perimetro de una circunferencia de radio {radio} es {perimetro}")

# 3 Define una constante IVA = 0.21 y calcula el precio final de un producto cuyo precio base es 100.
IVA = 0.21
precio = 100
print(f"El precio final es {precio + ( precio * IVA)}")

# 4 Declara dos números enteros y calcula su suma, resta, multiplicación, división y resto.
n1 = 5
n2 = 8
suma = n1 + n2
resta = n1- n2
mult = n1*n2
div = n1/n2
mod = n1%n2
print(f"Con los numeros {n1} y {n2}")
print(f"Suma: {suma} - Resta: {resta} - Multiplicacion: {mult} - Division: {div} - Modulo: {mod}")

# 5 Declara dos números reales y calcula la media aritmética. 
n1 = 8.7
n2 = 105
media = (n1 + n2) / 2
print(f"La media de {n1} y {n2} es: {media}")

# 6 Declara dos cadenas de texto ('Hola' y 'Mundo') y únelas en un solo mensaje con un espacio entre ellas. 
cad1 = "Hola"
cad2 = "Mundo"
print(f"{cad1} {cad2}")

# 7 Declara una variable de cada tipo básico (int, float, str, bool) e imprime su valor y su tipo con type(). 
entero = 10
flotante = 2.333
texto = "Transformes"
booleano = True
print(f"{entero} es de tipo {type(entero)}")
print(f"{flotante} es de tipo {type(flotante)}")
print(f"{texto} es de tipo {type(texto)}")
print(f"{booleano} es de tipo {type(booleano)}")

# 8 Pregunta al usuario su nombre con input() y muestra el tipo de la variable que se guarda. 
name = (input("Ingresa un nombre de usuario: "))
print("El tipoo de variable guardada es: " , type(name))

# 9 Crea una serie de valores de diferentes tipos (42, 'Python', 3.14, True) e imprime el tipo de cada uno usando varias líneas de print().
entero = 42
texto = 'Python'
flotante = 3.14
booleano = True
print(f"{entero} es de tipo {type(entero)}")
print(f"{flotante} es de tipo {type(flotante)}")
print(f"{texto} es de tipo {type(texto)}")
print(f"{booleano} es de tipo {type(booleano)}")

# 10 Declara una variable entera edad = 25. Convierte su valor a cadena y muéstralo en un mensaje. 
edad = 25
edad = str(edad)
print(edad)

# 11 Convierte la cadena '123' en entero y súmale 7. 
num = '123'
num = int(num) + 7
print(num)

# 12 Convierte la cadena '3.1416' en número decimal (float) y multiplícalo por 2.
num = '3.1416'
num = float(num) * 2
print(num)

# 13 Declara una variable booleana mayor_edad = True. Convierte su valor a entero y muéstralo en pantalla.
mayor_edad = True
mayor_edad = int(mayor_edad)
print(mayor_edad)

# 14 Escribe un programa que pida al usuario un número real y lo muestre convertido en entero.
num = input("Ingresa un numero real: ")
num = float(num)
num = int(num)
print(num)

# 15 Pide al usuario su nombre y edad. Muestra el mensaje: Hola "nombre", tienes "edad" años.
nombre = (input("Ingresa tu nombre: "))
edad = input("Ingresa tu edad")
print("Hola \"",nombre, "\", tienes \"", edad,"\" años" )

# 16 Pide al usuario dos números y muestra la suma, resta, producto y división de ambos. 
num1 = int(input("Ingresa un numero: "))
num2 = int(input("Ingresa el segundo numero: "))
print(f"La suma es: {num1 + num2}")
print(f"La resta es: {num1 - num2}")
print(f"El producto es: {num1 * num2}")
print(f"La division es: {num1 / num2}")

# 17 Pide al usuario el precio de un producto (número real) y muestra el precio con IVA (21%).
precio = float(input("Ingresa el precio del producto: "))
print(f"El precio con IVA: {precio + (precio * 0.21)}")

# 18 Pide al usuario su peso (kg) y altura (m), guárdalos en variables y muestra el cálculo del índice de masa corporal (IMC = peso / altura²). 
peso = float(input("Ingrea el peso: "))
altura = float(input("Ingresa la altura: "))
imc = peso / (altura * altura)
print(f"El IMC es: {imc}")

# 19 Pide al usuario un número decimal y muéstralo redondeado a entero. 
num = float(input("Ingresa el numero decimal: "))
num = round(num)
print(num)

# 20 Escribe un programa que calcule el área de un rectángulo a partir de la base y la altura introducidas por el usuario.
base = float(input("Ingresa la base: "))
altura = float(input("Ingresa la altura: "))
print(f"El area del rectangulo es {base * altura}")