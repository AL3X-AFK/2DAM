package BarberoDurmiente;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Cliente implements Runnable{
    int id;
    BlockingQueue<Cliente> salaDeEspera;
    Barbero barbero;

    public Cliente(int id, BlockingQueue<Cliente> salaDeEspera, Barbero barbero) {
        this.id = id;
        this.salaDeEspera = salaDeEspera;
        this.barbero = barbero;
    }

    @Override
    public void run() {

            try {
                Thread.sleep(generarNumero()*1000);

                synchronized (barbero) {

                        if (barbero.dormido) {
                            System.out.println("+CLIENTE " + id + " despierta al barbero");
                            barbero.dormido = false;
                            barbero.notify();

                        } else {
                            boolean exito = salaDeEspera.offer(this);
                            if (exito) {
                                System.out.println("+CLIENTE " + id + "  ha entrado a la sala");
                                if (!salaDeEspera.isEmpty()) {
                                    System.out.println("+CLIENTE " + id + "  se sienta a esperar");
                                }
                            } else{
                                System.out.println("Sala llena, el cliente se ha ido");
                            }
                    }
                
                }
            } catch (InterruptedException e) {
            }
        }
    

    public int generarNumero(){
        Random random = new Random();
        int num = random.nextInt(8)+2;
        return num;
    }

    
    
}
