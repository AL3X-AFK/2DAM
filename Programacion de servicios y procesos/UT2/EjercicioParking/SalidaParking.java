package EjercicioParking;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class SalidaParking implements Runnable{
    BlockingQueue<Coche>parking;
    ConcurrentHashMap<String,Double> registro;
    public static int cantidadCochesSalieron = 0;
    public static double recaudacionFinal = 0.0;

    public SalidaParking(BlockingQueue<Coche> parking, ConcurrentHashMap<String,Double> registro) {
        this.parking = parking;
        this.registro = registro;
    }

    @Override
    public void run() {

        //Tiempo de espera random entre 5 y 15 segs
        Random tiempoRandom = new Random();
        int min = 5000, max = 15000;

        while (!Thread.currentThread().interrupted()) {
            try {
                int tiempoEspera =min+ tiempoRandom.nextInt(max-min+1);
                Thread.sleep(tiempoEspera);

                //Obtengo el coche del parking
                Coche c = parking.take();
                cantidadCochesSalieron ++;


                //Calculo el tiempo de estancia
                long duracionMS = System.currentTimeMillis() - c.getHoraEntrada();
                long duracionSegundos = duracionMS/1000;
                //Calculo de precio
                double coste = duracionSegundos * 0.05;
                recaudacionFinal += coste;

                registro.put(c.getMatricula(), coste);

                System.out.println("<- Salida: ["+c.getMatricula()+ "] | Estancia: " + duracionSegundos + " min | Coste: " +coste+ " $" );
                
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
