#1
'''

try:
    num1 = int(input("Ingrese el primer numero: "))
    num2 = int(input("Ingrese el segundo numero: "))
    resultado = num1/num2
except ZeroDivisionError:
    print("No puedes dividir para cero :)")
else:
    print(num1/num2)
finally:
    print("Final")


#2
try:
    num = int(input("Ingresa un numero"))
except ValueError:
    print("Ingresa un numero coño")
else:
    print("El numero es: ",num)
finally:
    print("final")


#3
try: 
    num1 = int(input("Primer numero: "))
    num2 = int(input("Segundo numero: "))
    op = input("Ingresa el operador (+,-,*,/)")
except ValueError:
    print("Debes ingresar bien los valores")
except ZeroDivisionError:
    print("No se puede dividir para cero")
else:
    print("Operacion valida")
finally:
    print("fin")

opcion = 0
while opcion != 4:
    try:
        opcion = int(input("1.- Calcular si un numero es par o impar\n2.- Mostrar tabla de multiplicar de un numero del 1 al 10\n3.- Sumar numeros hasta que se introduzca cero\n4.- Salir\n"))
    except ValueError:
        print("Ingresa un valor valido")
        continue
    else:
        match opcion:
            case 1:
                try: 
                    num = int(input("Ingresa un numero para ver si es par o impar"))
                except ValueError:
                    print("Numero no valido")
                    continue
                if num%2 == 0:
                    print("El numero es par")
                else:
                    print("El numero es impar")
                    
            case 2:
                try:
                    num = int(input("Ingresa un numero para ver su tabla de multiplicar"))
                except ValueError:
                    print("Numero no valido")
                    continue
                for i in range (1,11):
                    print(num,"*",i,"=",num*i)

            case 3:
                
                suma = 0
                while True:
                    try:
                        num = int(input("Introduce un número (0 para terminar): "))
                    except ValueError:
                        print("Error: dato no válido\n")
                        continue

                    if num == 0:
                        break

                    suma += num
                    print("La suma es:", suma)
                print("Suma final:", suma, "\n")
                
            case 4:
                print("Saliendo...")
                break

            case _:
                print("Opcion no valida")
'''
