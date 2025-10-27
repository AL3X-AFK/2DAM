package EjercicioParking;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        System.out.println(resumenFinal(entrada, salida, parking, registro));
        
        try {
            FileWriter fileWriter = new FileWriter("DatosParking.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(resumenFinal(entrada, salida, parking, registro));
            bufferedWriter.close();
        } catch (IOException e) {
        }

        
    }

    public static String resumenFinal(EntradaParking entrada, SalidaParking salida, BlockingQueue<Coche>parking, ConcurrentHashMap<String, Double> registro){
        
        StringBuilder text = new StringBuilder();

        text.append("Resumen final: ");
        text.append("\nCoches que entraron: " + EntradaParking.cantidadCochesEntraron);
        text.append("\nCoches que salieron: " + SalidaParking.cantidadCochesSalieron);
        text.append("\nRecaudacion total: " + SalidaParking.recaudacionFinal +" $");
        text.append("\nCoches restantes en el parking: " + parking.size());
        text.append("\n\nRegistro detallado");
        registro.forEach((matricula, coste) ->
        text.append("\n  " + matricula + " -> " + coste + " $"));
        
        return text.toString();
    }
}
