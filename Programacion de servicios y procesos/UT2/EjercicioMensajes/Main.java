import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<Mensaje> cola = new LinkedBlockingDeque<Mensaje>(10);

        Emisor em1 = new Emisor(cola);
        Receptor re1 = new Receptor(cola);

        Thread hiloEmisor = new Thread(em1);
        Thread hiloReceptor = new Thread(re1);

        hiloEmisor.start();
        hiloReceptor.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
        }

        hiloEmisor.interrupt();
        hiloReceptor.interrupt();
    }
}
