menu = 0
while menu != 4:
    try:
        menu=int(input("Elige una opcion\n1.- Elegir personaje\n2.-Entrenar\n3.-Combate\n4.-Salir\n")) # type: ignore
    except ValueError:
        print("Ingreso un valor no valido")
        continue
    
    match menu:
        case 1:
            try:
                opcion = int(input("Elige una opcion\n1.- Goku\n2.-Luffy\n3.-Naruto\n"))
            except ValueError:
                print("Ingreso un valor no valido")
                continue

            match opcion:
                case 1:
                    print("Poder Saiyajin +50 🔥")
                case 2:
                    print("Haki del Rey +40 👑")
                case 3:
                    print("Modo Sabio +35 🌀")
                case _:
                    print("Opción incorrecta")

        case 2:
            try:
                reps = int(input("\n\nCuanta repeticiones quieres entrenar?\n"))
            except ValueError:
                print("Ingreso un valor no valido")
                continue

            for i in range (1,reps+1):
                print("Repeticion",i,": ¡sigues entrenando!")

        case 3:
            print("A combatir")
            vida = 100
            while vida > 0:
                try:
                    dano = int(input("Intrudice el daño que quieres hacer"))
                except ValueError:
                    print("Dato incorrecto")
                    continue
                vida = vida - dano
                print("Queda",vida," de salud")
                
            
            if vida <= 0:
                print("Victoria, has derrotado al enemigo")

        case 4:
            print("Saliendo")
            break
        case _:
            print("Opcion no valida")
    

