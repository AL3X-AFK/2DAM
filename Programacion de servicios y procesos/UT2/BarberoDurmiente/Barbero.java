package BarberoDurmiente;

import java.util.concurrent.BlockingQueue;

public class Barbero implements Runnable {
    boolean sillaOcupada = false;
    boolean dormido = true;
    BlockingQueue<Cliente> SalaDeEspera;
    boolean clientesLlegando;

    public Barbero(BlockingQueue<Cliente> SalaDeEspera, boolean dormido, boolean sillaOcupada) {
        this.SalaDeEspera = SalaDeEspera;
        this.dormido = dormido;
        this.sillaOcupada = sillaOcupada;
        this.clientesLlegando = true;
    }

    @Override
    public void run() {
        while (clientesLlegando) {
            try {
                Cliente c = null;

                synchronized (this) {
                    while (SalaDeEspera.isEmpty() && !sillaOcupada) {
                        System.out.println("-El BARBERO esta durmiendo...");
                        dormido = true;
                        wait();
                    }
                    if (!sillaOcupada && !SalaDeEspera.isEmpty()) {
                        c = SalaDeEspera.take();
                        sillaOcupada = true;
                        dormido = false;
                        System.out.println("+CLIENTE " + c.id + " se sienta en la silla");
                    }
                }

                if (c != null) {
                    System.out.println("-BARBERO corta el pelo a cliente " + c.id);
                    Thread.sleep(3000);
                    sillaOcupada = false;
                }


            } catch (InterruptedException e) {
                
            }
        }
    }
        
    }
    

