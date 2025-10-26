package EjercicioParking;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {

        ConcurrentHashMap<String, Double> registro = new ConcurrentHashMap<>();
        
        BlockingQueue<Coche> parking = new LinkedBlockingQueue(100);
        
        EntradaParking entrada = new EntradaParking(parking);
        SalidaParking salida = new SalidaParking(parking, registro);

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
        System.out.println("\nDeteniendo simulacion...\n");

        resumenFinal(entrada, salida, parking, registro);

    }

    public static void resumenFinal(EntradaParking entrada, SalidaParking salida, BlockingQueue<Coche>parking, ConcurrentHashMap<String, Double> registro){
        
        System.out.println("Resumen final: ");
        System.out.println("Coches que entraron: " + EntradaParking.cantidadCochesEntraron);
        System.out.println("Coches que salieron: " + SalidaParking.cantidadCochesSalieron);
        System.out.println("Recaudacion total: " + SalidaParking.recaudacionFinal +" $");
        System.out.println("Coches restantes en el parking: " + parking.size());
        System.out.println("\nRegistro detallado");
        registro.forEach((matricula, coste) ->
        System.out.println("  " + matricula + " -> " + coste + " €"));
    }
}
