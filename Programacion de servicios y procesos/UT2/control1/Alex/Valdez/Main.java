package control1.Alex.Valdez;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Menu de platos
        ArrayList<Plato> menu = new ArrayList<>();
        menu.add(new Plato("Ensalada", 1, 4.50));
        menu.add(new Plato("Sopa", 3, 3.75));
        menu.add(new Plato("Paella", 6, 14.99));

        //Cola de pedidos
        BlockingQueue<Pedido> pedidos = new LinkedBlockingQueue<>(50);
        //Cola de servidos
        BlockingQueue<Pedido> servidos = new LinkedBlockingQueue<>(50);

        Camarero camarero1 = new Camarero(1, pedidos, menu, servidos);
        Camarero camarero2 = new Camarero(2, pedidos, menu, servidos);
        Camarero camarero3 = new Camarero(3, pedidos, menu, servidos);
        Camarero camarero4 = new Camarero(4, pedidos, menu, servidos);
        Camarero camarero5 = new Camarero(5, pedidos, menu, servidos);
        
        Cocinero cocinero1 = new Cocinero(1,pedidos, servidos);
        Cocinero cocinero2 = new Cocinero(2, pedidos, servidos);

        Thread hiloCamarero1 = new Thread(camarero1, "Camarero-1");
        Thread hiloCamarero2 = new Thread(camarero2, "Camarero-2");
        Thread hiloCamarero3 = new Thread(camarero3, "Camarero-3");
        Thread hiloCamarero4 = new Thread(camarero4, "Camarero-4");
        Thread hiloCamarero5 = new Thread(camarero5, "Camarero-5");
        Thread hiloCocinero1 = new Thread(cocinero1, "Cocinero-1");
        Thread hiloCocinero2 = new Thread(cocinero2, "Cocinero-2");

        hiloCamarero1.start();
        hiloCamarero2.start();
        hiloCamarero3.start();
        hiloCamarero4.start();
        hiloCamarero5.start();
        hiloCocinero1.start();
        hiloCocinero2.start();

        try {
            Thread.sleep(30000);
            hiloCamarero1.interrupt();
            hiloCamarero2.interrupt();
            hiloCamarero3.interrupt();
            hiloCamarero4.interrupt();
            hiloCamarero5.interrupt();
        } catch (InterruptedException e) {
        }

        hiloCamarero1.join();
        hiloCamarero2.join();
        hiloCamarero3.join();
        hiloCamarero4.join();
        hiloCamarero5.join();

        hiloCocinero1.interrupt();
        hiloCocinero2.interrupt();
        hiloCocinero1.join();
        hiloCocinero2.join();

        System.out.println("******************* RESUMEN DEL DIA *******************");
        System.out.println("*** Facturacion total del día: " + (camarero1.ingresoTotalDelDia + camarero2.ingresoTotalDelDia + camarero3.ingresoTotalDelDia + camarero4.ingresoTotalDelDia + camarero5.ingresoTotalDelDia) + "$");
    }

    

}
