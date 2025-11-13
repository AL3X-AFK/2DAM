package BarberoDurmiente2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Barberia {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Cliente> colaDeEspera = new LinkedBlockingQueue<>(5);
        Barbero barbero = new Barbero(colaDeEspera);

        Thread hiloBarbero = new Thread(barbero);
        hiloBarbero.start();

        List<Thread> clientesThreads = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Thread hiloCliente = new Thread(new Cliente(colaDeEspera, i, barbero));
            clientesThreads.add(hiloCliente);
            hiloCliente.start();
        }

        // Esperar a que todos los clientes terminen
        for (Thread thread : clientesThreads) {
            thread.join();
        }
        
        barbero.abierto = false;
        synchronized(barbero) {
            barbero.notifyAll();
        }
        
        hiloBarbero.join();

        System.out.println("FIN DE LA SIMULACION");
    }
}
