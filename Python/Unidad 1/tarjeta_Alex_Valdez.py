#Pido al usuario todos los datos
print("****************************************")
print("*  Bienvenid@ a la página de registro  *")
print("****************************************")
print("Datos del usuario")
nombre = input("Ingrese su nombre de usuario: ")
iden= input("Ingresa tu id: ")
edad = int(input("Ingrese su edad: "))
alturaEnM = float(input("Ingrese su altura en metros: "))
ciudad = input("Ingrese si ciudad de residencia: ")
deporte = input("Ingrese su deporte: ")

#Variables y constantes
EDAD_JUBILACION = 65 #Constante de jubilacion
aniosFaltantes = EDAD_JUBILACION - edad #Calculo los años que faltan para la jubilacion restando la constante menos la edad

# Operaciones y conversiones
alturaEnCM = int(alturaEnM * 100) #Transformo la altura a cm y la hago entera
edad = str(edad) # Trandformo la edad a cadena de texto

# Salida
print("\n|==============================|")
print("     TARJETA INTERACTIVA")
print("|==============================|")
print(f"|Nombre: {nombre} con ID: {iden}")
print(f"|Edad: {edad} años")
print(f"|Altura: {alturaEnCM} cm")
print(f"|Ciudad: {ciudad}")
print(f"|Deporte: {deporte}")
print(f"|Años hasta la jubilaciion: {aniosFaltantes}")
print("|==============================|")

