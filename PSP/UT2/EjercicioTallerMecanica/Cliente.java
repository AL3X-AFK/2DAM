package EjercicioTallerMecanica;

import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class Cliente implements Runnable{

    LinkedBlockingQueue<Reparacion> cola;
    List<Reparacion> listaReparaciones;


    public Cliente(LinkedBlockingQueue<Reparacion> cola, List<Reparacion> listaReparaciones) {
        this.cola = cola;
        this.listaReparaciones = listaReparaciones;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int cantidadReparaiones = generarNumero();

                
                System.out.println(Thread.currentThread().getName() + " llega al taller con " + cantidadReparaiones+" reparaciones.");

                    for (int i = 0; i < cantidadReparaiones; i++) {
                        int x = elegirReparacion();
                        Reparacion r = new Reparacion(listaReparaciones.get(x).tipo, listaReparaciones.get(x).tiempo, listaReparaciones.get(x).precio);
                        System.out.println(Thread.currentThread().getName() + " solicita: " + listaReparaciones.get(x).tipo + " ( " + listaReparaciones.get(x).tiempo +"s, " + listaReparaciones.get(x).precio +"$ )");
                        
                        cola.put(r);
                }
                
                
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    
    int generarNumero(){
        int numero;
        Random random = new Random();
        numero = random.nextInt(3)+1;
        return numero;
    }

    int elegirReparacion(){
        int numero;
        Random random = new Random();
        numero = random.nextInt(listaReparaciones.size());
        return numero;
    }
    
}
