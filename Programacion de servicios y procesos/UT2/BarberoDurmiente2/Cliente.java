package BarberoDurmiente2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Cliente implements Runnable{
    BlockingQueue<Cliente> colaDeEspera;
    int id;
    Barbero barbero;

    public Cliente(BlockingQueue<Cliente> colaDeEspera, int id, Barbero barbero) {
        this.colaDeEspera = colaDeEspera;
        this.id = id;
        this.barbero = barbero;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(generarNumero() * 1000);
            
            boolean entro = colaDeEspera.offer(this);
            
            if (entro) {
                System.out.println("Cliente " + this.id + " entra en la barberia");
                
                synchronized(this) {
                    this.wait(); // Esperar a que el barbero le notifique
                }
                
                System.out.println("Cliente " + this.id + " se va satisfecho");
            } else {
                System.out.println("Cliente " + this.id + " - la barberia esta llena, se va");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int generarNumero(){
        Random random = new Random();
        return random.nextInt(8) + 2;
    }
}
