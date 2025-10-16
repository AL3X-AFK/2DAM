
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class Consumidor implements Runnable {

    BlockingQueue<String> cinta;
    private boolean running = true;
    HashMap<String, Integer> mapa = new HashMap<>();

    public Consumidor(BlockingQueue<String> cinta) {
        this.cinta = cinta;
    }

    @Override
    public void run(){

        try {
            while (running || !cinta.isEmpty()) {
                String producto = cinta.take();
                System.out.println("Se empaqueta el producto: " + producto + " por " + Thread.currentThread().getName());
                int duration = (int)(Math.random()*500+300);
                Thread.sleep(duration);
                System.out.println("Se Termina de empaquetar el producto: " + producto + " por " + Thread.currentThread().getName());

            }
        } catch (Exception e) {
        }
    }

    public void detener(){
        this.running=false;
    }


}
