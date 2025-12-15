n = int(input("Ingresa el numero de discos: "))

torres = {
    "A":list(range(n,0,-1)),
    "B":[],
    "C":[]
}

def mostrarEstado():
    print("---------------")
    print("A:",torres["A"])
    print("B:",torres["B"])
    print("C:",torres["C"])

def mover(dic, origen, destino):
    disco = dic[origen].pop()
    dic[destino].append(disco)


print("Estado inicial")
mostrarEstado()


def hanoi(n, origen, aux, destino):
    if n == 1:
        mover(torres, origen, destino)
        mostrarEstado()
        return
    

    hanoi(n-1, origen, destino, aux)
    mover(torres, origen, destino)
    mostrarEstado()

    hanoi(n-1, aux, origen, destino)
       

hanoi(n, "A", "B", "C")