
import java.util.concurrent.BlockingQueue;

public class Receptor implements Runnable{

    BlockingQueue<Mensaje> cola;

    public Receptor(BlockingQueue<Mensaje> cola) {
        this.cola = cola;
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) { 
            try {

                Thread.sleep(3000);
                Mensaje m = cola.take();
                System.out.println("RECIBIDO " + m.getTipo()+": " + m.getMensaje() + ": " + m.getFecha());

            } catch (InterruptedException e) {
            }
            

        }
    }
    
    
}
