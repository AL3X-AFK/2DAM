
import java.util.concurrent.BlockingQueue;

public class ConsumidorParking implements Runnable {
    
    private final Parking parking;
    private final BlockingQueue<Coche>colaAcceso;

    public ConsumidorParking(BlockingQueue<Coche> colaAcceso, Parking parking) {
        this.colaAcceso = colaAcceso;
        this.parking = parking;
    }
    
    

    @Override
    public void run(){
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Coche c = colaAcceso.take();

                boolean entro = false;
                while (!entro) { 
                    parking.entrarCoche(c);
                    if(!entro){
                        Thread.sleep(200);
                    }
                }
            }
        } catch (InterruptedException e) {
        }
    }
}
