package ej2;

public class Contador {
    
    private int contador = 0;


    public synchronized void sumar() {
        contador++;
    }


    public int getValor() {
        return contador;
    }

}
