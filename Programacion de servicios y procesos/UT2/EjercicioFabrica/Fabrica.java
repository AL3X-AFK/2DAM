
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Fabrica {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> cinta = new ArrayBlockingQueue<>(5);

        Productor productor = new Productor(cinta);
        Consumidor consumidor = new Consumidor(cinta);

        Thread hiloProductor = new Thread(productor, "productor");
        Thread hiloConsumidor1 = new Thread(consumidor, "consumidor 1");
        Thread hiloConsumidor2 = new Thread(consumidor, "consumidor 2");

        hiloProductor.start();
        hiloConsumidor1.start();
        hiloConsumidor2.start();

        TimeUnit.SECONDS.sleep(10); //Se para durante 10 segundos
    
        productor.detener();
        consumidor.detener();

        while (!cinta.isEmpty()) {
            Thread.sleep(1000);
        }

        hiloProductor.interrupt();
        hiloConsumidor1.interrupt();
        hiloConsumidor2.interrupt();


        hiloProductor.join();
        hiloConsumidor1.join();
        hiloConsumidor2.join();

        System.out.println("Simulacion detenida");
    }
}
