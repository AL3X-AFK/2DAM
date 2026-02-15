package EjercicioTallerMecanica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class TallerMecanico {
    public static void main(String[] args) throws InterruptedException {

        //Catalogo de reparaciones
        List<Reparacion> listaReparaciones = new ArrayList<>();
        listaReparaciones.add(new Reparacion("Cambio de aceite", 1, 5.00));
        listaReparaciones.add(new Reparacion("Cambio de frenos", 3, 45.00));
        listaReparaciones.add(new Reparacion("ITV", 2, 100.00));
        
        //Mapa para mecanicos
        HashMap<String, Double[]> mapaMecanico = new HashMap<>();

        //Cola
        LinkedBlockingQueue<Reparacion> cola = new LinkedBlockingQueue<>(10); 

        Cliente c = new Cliente(cola, listaReparaciones);
        Mecanico m = new Mecanico(cola, mapaMecanico);

        Thread cliente1 = new Thread(c, "Cliente 1");
        Thread cliente2 = new Thread(c, "Cliente 2");
        Thread mecanico1 = new Thread(m, "Mecanico 1");
        Thread mecanico2 = new Thread(m, "Mecanico 2");

        cliente1.setPriority(Thread.MAX_PRIORITY);
        cliente2.setPriority(Thread.MIN_PRIORITY);

        mecanico1.setPriority(Thread.MAX_PRIORITY);
        mecanico2.setPriority(Thread.MIN_PRIORITY);

        cliente1.start();
        cliente2.start();

        mecanico1.start();
        mecanico2.start();

       try {
            Thread.sleep(5000);
            cliente1.interrupt();
            cliente2.interrupt();
        } catch (InterruptedException e) {
        }

        cliente1.join();
        cliente2.join();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
        }

        mecanico1.interrupt();
        mecanico2.interrupt();

        try {
            mecanico1.join();
            mecanico2.join();
        } catch (InterruptedException e) {
        }

        System.out.println("\n------- RESUMEN INDIVIDUAL -------");
        int totalTrabajos = 0;;
        Double facturacionTotal = 0.0;

        synchronized (mapaMecanico) {
            for (var entry : mapaMecanico.entrySet()) {
                String nombre = entry.getKey();
                Double[] datos = entry.getValue();
                totalTrabajos += datos[0];
                facturacionTotal += datos[1];
                System.out.println(nombre + " -> + Trabajos: " + datos[0].intValue() + " | Recaudacion: " + datos[1] + "$");
            }

            System.out.println("\n ---- RESUMEN DEL DÍA -----------");
            System.out.println("   Trabajos realizados: "+ totalTrabajos);
            System.out.println("   Facturación total: " + facturacionTotal + " $");
            System.out.println("  ----- Fin de la simulación. -----");
        }

        


    }
}
