package EjercicioParking;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<Coche> parking = new LinkedBlockingQueue(100);
        EntradaParking entrada = new EntradaParking(parking);
        SalidaParking salida = new SalidaParking(parking);

        Thread hiloEntrada = new Thread(entrada);
        Thread hiloSalida = new Thread(salida);

        hiloEntrada.start();
        hiloSalida.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            
        }

        hiloEntrada.interrupt();
        hiloSalida.interrupt();

        resumenFinal(entrada, salida, parking);

    }

    public static void resumenFinal(EntradaParking entrada, SalidaParking salida, BlockingQueue<Coche>parking){
        System.out.println("Resumen final: ");
        System.out.println("Coches que entraron: " + EntradaParking.cantidadCochesEntraron);
        System.out.println("Coches que salieron: " + SalidaParking.cantidadCochesSalieron);
        System.out.println("Recaudacion total: " + SalidaParking.recaudacionFinal +" $");
        System.out.println("Coches restantes en el parking: " + parking.size());
    }
}
