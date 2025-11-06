package EjercicioTallerMecanica;

import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class Mecanico implements Runnable{

    LinkedBlockingQueue<Reparacion> cola;
    int totalTrabajos;
    double recaudacionPersonal;
    HashMap<String, Double[]> mapaMecanico;


    public Mecanico(LinkedBlockingQueue<Reparacion> cola, HashMap<String, Double[]> mapaMecanico) {
        this.cola = cola;
        this.totalTrabajos = 0;
        this.recaudacionPersonal = 0;
        this.mapaMecanico = mapaMecanico;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Reparacion r = cola.take();

                Thread.sleep(r.tiempo*1000);

                System.out.println(Thread.currentThread().getName() +" " + r.tipo + " ( " + r.tiempo + "s, " + r.precio + "$ )");
                totalTrabajos ++;
                recaudacionPersonal += r.precio;

                synchronized (mapaMecanico) {
                    Double[] datos = mapaMecanico.getOrDefault(Thread.currentThread().getName(), new Double[]{0.0, 0.0});
                    datos[0] ++;
                    datos[1] += r.precio;
                    mapaMecanico.put(Thread.currentThread().getName(), datos);
                }
               
            } 
        }catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " terminó su jornada");
        }
    }
    
    
}
