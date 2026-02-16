package EjercicioParking;

import java.util.concurrent.BlockingQueue;

public class EntradaParking implements Runnable {
    
    BlockingQueue<Coche> parking;
    public static int cantidadCochesEntraron = 0;

    public EntradaParking(BlockingQueue<Coche> parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            
            Coche c = new Coche();
            
            try {
                parking.put(c);
                System.out.println("-> Entrada: [" + c.getMatricula() + "] | Plazas ocupadas: " + parking.size() +"/100");
                cantidadCochesEntraron++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
