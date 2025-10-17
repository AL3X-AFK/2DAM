
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {

    BlockingQueue<String> cinta;
    private boolean running = true;
    private final Map<String, Integer> productosPorHilo = new HashMap<>();

    public Consumidor(BlockingQueue<String> cinta) {
        this.cinta = cinta;
    }

    @Override
    public void run(){

        try {
            while (running || !cinta.isEmpty()) {
                String producto = cinta.take();

                String nombreHilo = Thread.currentThread().getName();

                System.out.println("Se empaqueta el producto: " + producto + " por " + nombreHilo);
                
                
                int duration = (int)(Math.random()*500+300);
                
                Thread.sleep(duration);

                productosPorHilo.merge(nombreHilo, 1, Integer::sum);

                System.out.println("Se Termina de empaquetar el producto: " + producto + " por " + nombreHilo);

            }
        } catch (InterruptedException e) {
        }
    }

    public void detener(){
        this.running=false;
    }

    public Map<String, Integer> getProductosPorHilo() {
        return productosPorHilo;
    }

}
