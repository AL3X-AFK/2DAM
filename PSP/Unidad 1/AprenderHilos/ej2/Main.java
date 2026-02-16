package ej2;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        Thread hilo1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                contador.sumar();
            }
        });

        Thread hilo2 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                contador.sumar();
            }
        });

        hilo1.start();
        hilo2.start();

        try {
            hilo2.join();
        } catch (InterruptedException e) {
        }
        
        try {
            hilo1.join();
        } catch (InterruptedException e) {
        }


        System.out.println("El contador vale: " + contador.getValor());

    }
}
