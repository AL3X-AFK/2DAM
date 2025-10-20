import ejercicios_ampliacion_alx_v

#1. Mostrar los números del 1 al 10 usando un while.
i = 1
while i<=10 :
    print(i)
    i = i+1

#2. Mostrar los números del 1 al 10 usando un for y range().
i = 1
while i in range (10+1) :
    print(i)
    i = i+1

#3. Pedir un número al usuario y mostrar la cuenta atrás hasta 0.
x = int(input("Ingresa un numero: "))
while x >= 0:
    print(x)
    x = x-1

#4. Mostrar los números pares del 1 al 20.
for i in range(2, 21 ,2):
    print (i)

#5. Calcular y mostrar la suma de los números del 1 al 10.
suma = 0
for i in range (1, 11):
    suma += i
print (suma)

#6. Pedir un número y mostrar su tabla de multiplicar del 1 al 10.
num = int(input("Ingresa un numero: "))
for i in range (1, 11):
    print (f"{num} * {i} = {num*i}")
    
#7. Pedir al usuario números hasta que introduzca un 0, y mostrar la suma total.
num = int(input("ingresa un numero: "))
suma = 0
while (num!= 0):
    suma += num
    num = int(input("ingresa un numero: "))
print(f"La suma de los numeros es: {suma}")

#8. Dada la lista ["manzana", "pera", "uva"], mostrar cada elemento.
lista = ["manzana", "pera", "uva"]
for fruta in lista:
    print (fruta)

#9. Pedir al usuario una palabra y mostrar cada letra en una línea.
palabra = input("Ingresa una palabra: ")
for i in palabra:
    print (i)

#10. Pedir una palabra y contar cuántas letras tiene usando un bucle.
palabra = input("Ingresa una palabra: ")
suma = 0
for i in palabra:
    suma += 1
print (f"Hay {suma} letras")

#11. Mostrar los impares entre 1 y 50 usando continue.
for x in range(1, 50):
    if x % 2 == 0:
        continue
    print (x)

#12. Pedir números al usuario hasta que introduzca uno que sea múltiplo de 7.
num = int(input("Ingresa un numero: "))
while num%7 != 0:
    num = int(input("Ingresa un numero: "))

#13. El ordenador tiene un número secreto (ej. 15) y el usuario debe adivinarlo.
NUM = 15
x = int(input("Ingresa el numero: "))
while x != NUM:
    x = int(input("Ingresa el numero: "))
print("ADIVINASTE")


#14. Repetir un menú con opciones (1. Saludar, 2. Despedir, 3. Salir) hasta que el usuario elija salir.
print("1. Saludar, 2. Despedir, 3. Salir")
val = int(input("Selecciona una opcion: "))
while val != 3:
    print("1. Saludar, 2. Despedir, 3. Salir")
    val = int(input("Selecciona una opcion: "))
   
#15. Pedir notas hasta que el usuario introduzca -1. Mostrar la media de todas.
nota = int(input("Ingresa una nota: "))
suma = 0
total = 0
while nota != -1:
    suma += nota
    total += 1
    nota = int(input("Ingresa una nota: "))
print(f"Media: {suma/total}")

#16. Pedir un número n y mostrar los n primeros números de la serie de Fibonacci.
num = int(input("Ingresa el numero: "))
x = 0
y = 1
for i in range(num+1):
    print(f"{x} + {y} = {x+y}")
    suma = x+y
    x = y
    y = suma

#17. Pedir un número y mostrar si es primo comprobando sus divisores con un bucle.
x = int(input("Ingresa el numero: "))
sum = 0
for i in range (1, x+1):
    if x % i == 0:
        sum += 1
if sum > 2:
    print("No es primo")
else:
    print("Si es primo")

#18. Simular un login de usuario - contraseña con 3 posibles intentos.
C = "hola"
for _ in range(3):
    x = input("Ingrese la contraseña: ")
    if x == C:
        print("Correcto")
        break
    
