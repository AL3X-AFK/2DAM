
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cola {
    public static void main(String[] args) {


        BlockingQueue<Coche> colaEspera = new LinkedBlockingQueue<>();
        Parking parking = new Parking(10);

        Thread productor = new Thread(new ProductorCoches(colaEspera));
        Thread consumidor = new Thread(new ConsumidorParking(colaEspera, parking));
        Thread salida = new Thread(new SalidaParking(parking));

        productor.start();
        consumidor.start();
        salida.start();


        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
        }
        

        productor.interrupt();
        consumidor.interrupt();
        salida.interrupt();


        System.out.println("Simulacion terminada");
        
    }
}
