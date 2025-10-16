import java.util.concurrent.BlockingQueue;

public class Productor implements Runnable {

    private BlockingQueue<String> cinta;
    private int contador = 1;
    private boolean  running = true;


    public Productor(BlockingQueue<String> cinta) {
        this.cinta = cinta;
    }

    

    @Override
    public void run() {
        try {
            while (running) {
                
                String producto = "Producto - "+contador++;
                System.out.println("Se produce el " + producto);

                cinta.put(producto);
                int tiempoEspera = (int)(Math.random()*400+100);
                Thread.sleep(tiempoEspera);
            }
        } catch (Exception e) {

        }
    }

    public void detener(){
        this.running=false;
    }

    
}
