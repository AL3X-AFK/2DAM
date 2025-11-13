package BarberoDurmiente;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SalaDeEspera {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Cliente> salaDeEspera = new LinkedBlockingQueue<>(5);
        
        Barbero b = new Barbero(salaDeEspera, true, false);
        

        Thread hiloBarbero = new Thread(b);

        List<Thread> clientes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread hiloCliente = new Thread(new Cliente(i, salaDeEspera, b));
            hiloCliente.start();
            clientes.add(hiloCliente);
        }

        hiloBarbero.start();

        Thread.sleep(10000);

        for (Thread cliente : clientes) {
            cliente.join();
        }

        b.clientesLlegando = false;

        hiloBarbero.interrupt();
        hiloBarbero.join();

        System.out.println("Simulacion detenida");
    }
}
