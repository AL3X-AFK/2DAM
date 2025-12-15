def factorial(n):
    if n == 0:
        return 1
    else:
        resultado = n * factorial(n-1)
        return resultado

print(factorial(6))