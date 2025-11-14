package BarberoDurmiente2;

import java.util.concurrent.BlockingQueue;

public class Barbero implements Runnable{
    BlockingQueue<Cliente> colaDeEspera;
    boolean dormido;
    boolean abierto;

    public Barbero(BlockingQueue<Cliente> colaDeEspera) {
        this.colaDeEspera = colaDeEspera;
        this.dormido = true;
        this.abierto = true;
    }

    @Override
    public void run() {
        while (abierto || !colaDeEspera.isEmpty()) {
            try {
                Cliente c = colaDeEspera.poll();
                
                if (c != null) {
                    // Cliente disponible en la cola
                    synchronized(this) {
                        dormido = false;
                    }
                    System.out.println("El barbero atiende al cliente " + c.id);
                    Thread.sleep(3000);
                    System.out.println("El barbero termina con el cliente " + c.id);
                    
                    synchronized(c) {
                        c.notifyAll(); // Notificar al cliente que termino
                    }
                } else if (abierto) {
                    // No hay clientes
                    synchronized(this) {
                        if (colaDeEspera.isEmpty() && abierto) {
                            dormido = true;
                            System.out.println("El barbero se duerme");
                            this.wait(500);
                        }
                    }
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println("El barbero cierra la barberia");
    }
}
