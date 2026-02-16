
import java.util.concurrent.BlockingQueue;

public class ProductorCoches implements Runnable {
    private final BlockingQueue<Coche> colaAcceso;

    public ProductorCoches(BlockingQueue<Coche> colaAcceso) {
        this.colaAcceso = colaAcceso;
    }


    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) { 
                Coche c = new Coche(Coche.generarMatricula());

                colaAcceso.put(c);
                System.out.println("Coche en cola de acceso: " + c);
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
        }
    }


}
