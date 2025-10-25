package EjercicioParking;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class SalidaParking implements Runnable{
    BlockingQueue<Coche>parking;
    public static int cantidadCochesSalieron = 0;
    public static double recaudacionFinal = 0.0;

    public SalidaParking(BlockingQueue<Coche> parking) {
        this.parking = parking;
    }

    @Override
    public void run() {

        //Tiempo de espera random entre 5 y 15 segs
        Random tiempoRandom = new Random();
        int min = 5000, max = 15000;

        while (!Thread.currentThread().interrupted()) {
            try {
                int tiempoEspera =min+ tiempoRandom.nextInt(max-min+1);

                //Obtengo el coche del parking
                Coche c = parking.take();
                cantidadCochesSalieron ++;

                Thread.sleep(tiempoEspera);

                //Calculo el tiempo de estancia
                long duracionMS = System.currentTimeMillis() - c.getHoraEntrada();
                long duracionSegundos = duracionMS/1000;
                //Calculo de precio
                double coste = duracionSegundos * 0.05;
                recaudacionFinal += coste;

                System.out.println("<- Salida: ["+c.getMatricula()+ "] | Estancia: " + duracionSegundos + " min | Coste: " +coste+ " $" );
                
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
