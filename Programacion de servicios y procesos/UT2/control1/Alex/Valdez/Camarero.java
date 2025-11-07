package control1.Alex.Valdez;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Camarero implements Runnable {
    
    int id;
    Pedido pedido;
    ArrayList<Plato> menu;
    BlockingQueue<Pedido> pedidos;
    BlockingQueue<Pedido> servidos;
    Double ingresoTotalDelDia = 0.0;

    public Camarero(int id, BlockingQueue<Pedido> pedidos, ArrayList<Plato> menu, BlockingQueue<Pedido> servidos) {
        this.id = id;
        this.menu = menu;
        this.pedido = new Pedido(new ArrayList<>(), 0);
        this.pedidos = pedidos;
        this.servidos = servidos;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int random = new Random().nextInt(3) + 1;

                for (int i = 0; i < random; i++) {
                    Plato plato = elegirPlato();
                    pedido.idMesa = id;
                    pedido.platos.add(plato);
                    pedido.total += plato.precio;
                }

                System.out.println("+ Camarero: " + pedido.idMesa + " ha tomado pedido con " + random + " platos.");
                

                Thread.sleep(3000);
                pedidos.put(pedido);
                System.out.println("+ Camarero: " + pedido.idMesa + " ha enviado el pedido a cocina.");

                //Pedido servido llega de cocina a camarero
                Pedido pedidoServido = servidos.take();
                System.out.println("+ Camarero: " + pedidoServido.idMesa + " sirve el pedido.");
                System.out.println("* Cliente " + " está comiendo...");

                int tiempoComer = new Random().nextInt(5) + 5;
                Thread.sleep(tiempoComer * 1000);
                System.out.println("+ Camarero: " + pedidoServido.idMesa + " ha terminado de atender el pedido. Cuenta total: " + pedidoServido.total + "$");
                ingresoTotalDelDia += pedidoServido.total;

            } catch (InterruptedException e) {  
                Thread.currentThread().interrupt();
            }
        }
        
    }
    Plato elegirPlato() {
        Plato plato;
        int numero = new Random().nextInt(menu.size());
        plato = menu.get(numero);
        return plato;
    }



}
