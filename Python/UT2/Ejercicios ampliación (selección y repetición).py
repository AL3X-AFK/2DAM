'''
#1 Suma de números pares e impares. Pide un número n y calcula por separado la suma de los números pares y de los impares entre 1 y n.
x = int(input("Ingresa un numero: "))
sumaPares = 0
sumaImpares = 0
for i in range(1, x+1):
    if i % 2 == 0:
        sumaPares += i
    else:
        sumaImpares += i
print(f"Suma pares: {sumaPares}") 
print(f"Suma impares: {sumaImpares}") 

#2 Números divisibles por 3 y 5. Muestra todos los números del 1 al 100 que sean divisibles por 3 o por 5, pero no por ambos.
for i in range (1, 101):
    if (i % 3 == 0) ^ (i % 5 == 0):
        print(i, end=" - ")

#3 Factorial de un número. Pide un número entero positivo y calcula su factorial (n!). (Usar un bucle for o while)
x = int(input("Ingresa un numero entero positivo: "))
factorial = 0
for i in range(x-1, 0,-1):
    x = x * i
print("Factorial: " , x)

#4 Contar de dígitos pares e impares. Pide un número y determina cuántos de sus dígitos son pares y cuántos impares.
x = input("Ingresa un numero entero positivo: ")
pares = 0
impares = 0
for digito in x:
    digito = int(digito)
    if digito %2 == 0:
        pares += 1
    else:
        impares += 1
print("Pares: ",pares)
print("Impares: ",impares)

#5 Suma de una serie aritmética. Calcula la suma de los n primeros términos de una serie aritmética, sabiendo el primer 
#término a1 y la diferencia d. Fórmula: Sn = n/2 * (2*a1 + (n-1)*d). (Pide los datos y verifica que n sea positivo).
n = int(input("Ingresa n: "))
while(n <= 0):
    print("Debe ser positivo")
    n = int(input("Ingresa n: "))
a1 = int(input("Ingresa el primer termino: "))
d = int(input("Ingresa la diferencia: "))
print("Sn= ",n/2 * (2*a1 + (n-1)*d))

#6 Serie de Fibonacci. Pide un número n y muestra los primeros n términos de la serie de Fibonacci.
n = int(input("Ingresa n: "))
x = 0
y = 1
for _ in range(n+1):
    print(f"{x} + {y} = {x+y}")
    suma = x+y
    x = y
    y = suma

#7 Números perfectos. Un número es perfecto si es igual a la suma de sus divisores (excepto él mismo). Pide un número y determina si es perfecto.
n = int(input("Ingresa n: "))
suma = 0
for i in range ( 1, n):
    if n % i == 0:
        suma += i
if suma == n:
    print("Es perfecto")
else:
    print("No es perfecto")    

#8 Potencias sin usar operador **. Pide una base y un exponente, y calcula la potencia mediante multiplicaciones sucesivas.
base = int(input("Ingresa la base: "))
pot = int(input("Ingresa la potencia: "))
x = base
y = base
for _ in range(pot -1):
    res = x * y
    x = res
print (res)
'''
#9 Inversión de número. Pide un número entero y muestra su valor invertido (por ejemplo, 1234 → 4321).

#10 Palíndromo numérico. Determina si un número leído por teclado es palíndromo (se lee igual al derecho y al revés).
#11 Conversión decimal → binario. Pide un número entero positivo y convierte a binario sin usar bin(). (Usar divisiones sucesivas entre 2 y guardar los restos.)
#12 Máximo común divisor (MCD). Calcula el MCD de dos números usando el algoritmo de Euclides.
#13 Triángulo de Pascal. Pide un número de filas n y muestra el triángulo de Pascal con bucles anidados.
#14 Números primos en un rango. Pide dos números a y b y muestra todos los primos entre a y b.
#15 Descomposición en factores primos. Pide un número y muestra su descomposición en factores primos.
#16 Suma de dígitos repetida. Pide un número y suma sus dígitos repetidamente hasta obtener una sola cifra (número digital).
#17 Detectar número Armstrong. Un número de 3 cifras es Armstrong si la suma de sus dígitos elevados al cubo es igual al propio número. (Ejemplo: 153 → 1³ + 5³ + 3³ = 153)
#18 Cifras crecientes. Pide un número y determina si sus cifras están en orden creciente (ejemplo: 1359 ✅, 1324 ❌).
#19 Números primos gemelos. Muestra todos los pares de números primos menores de 100 que difieren en 2 unidades.
#20 Secuencia de Collatz (o conjetura del 3n+1). Pide un número y genera la secuencia hasta llegar a 1: Si es par, se divide entre 2. Si es impar, se multiplica por 3 y se suma 1. (Mostrar la secuencia completa.)