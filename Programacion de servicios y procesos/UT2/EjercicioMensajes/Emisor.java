
import java.util.concurrent.BlockingQueue;

public class Emisor implements Runnable{
    BlockingQueue<Mensaje> cola;

    public Emisor(BlockingQueue<Mensaje> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) { 

            Mensaje m = new Mensaje();

            try {
                cola.put(m);
                Thread.sleep(2000);
                System.out.println("EMITIDO " + m.getTipo()+": " + m.getMensaje() + ": " + m.getFecha());

            } catch (InterruptedException e) {
                break;
            }
        }
    }

    
}
