package Ej1;

public class Main {
    public static void main(String[] args) {
        HiloNumeroLetras h1 = new HiloNumeroLetras(1);
        HiloNumeroLetras h2 = new HiloNumeroLetras(2);

        Thread hilo1 = new Thread(h1);
        Thread hilo2 = new Thread(h2);

        hilo1.start();
        hilo2.start();
    }
}
