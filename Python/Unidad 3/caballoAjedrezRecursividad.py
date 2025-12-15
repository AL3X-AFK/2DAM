MOVS_CABALLO = [
    (2, 1), (1, 2),
    (-1, 2), (-2, 1),
    (-2, -1), (-1, -2),
    (1, -2), (2, -1)
]


def es_valido(x,y,tablero):
    n = len(tablero)
    return 0 <= x < n and 0 <= y < n and tablero[x][y] == 0


def mostrar_tablero(tablero):
    print("Tablero:")
    for fila in tablero:
        fila_str=""
        for valor in fila:
            fila_str += f"{valor:3d}"
        print(fila_str)
        print()



def recorrido_caballo(tablero, x, y, paso):
    n = len(tablero)
    tablero[x][y] = paso

    if n*n == paso:
        return True
    
    for dx, dy in MOVS_CABALLO:
        nx = x+dx
        ny = y+dy
        if es_valido(nx,ny,tablero):
            if recorrido_caballo(tablero, nx, ny, paso+1):
                return True
            
    tablero[x][y] = 0
    return False   




def resolver_recorrido_caballo(n):
    tablero = [[0 for _ in range(n)]for _ in range (n)]

    if recorrido_caballo(tablero,0,0,1):
        print(f"Recorrido encontrado en un tablero de {n}x{n}:")
        mostrar_tablero(tablero)
    else:
        print(f"No se ha encontrado recorrido en un tablero de {n}x{n}")



valor = int(input("Ingresa el tamaño del tablero: "))
resolver_recorrido_caballo(valor)