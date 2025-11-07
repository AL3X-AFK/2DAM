package control1.Alex.Valdez;

import java.util.concurrent.BlockingQueue;

public class Cocinero implements Runnable {
    
    int id;
    BlockingQueue<Pedido> pedidos;
    BlockingQueue<Pedido> servidos;

    public Cocinero(int id, BlockingQueue<Pedido> pedidos, BlockingQueue<Pedido> servidos) {
        this.id = id;
        this.pedidos = pedidos;
        this.servidos = servidos;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Pedido llega a cocinero
                Pedido pedido = pedidos.take();

                System.out.println("- Cocinero " + id + ": preparando el pedido: " +  pedido.idMesa);
                Thread.sleep(pedido.platos.stream().mapToInt(plato -> plato.tiempoPreraracion).sum() * 1000);
                System.out.println("- Cocinero " + id + ": el pedido " + pedido.idMesa + " listo para servir");

                //Pedido sale de cocinero
                servidos.put(pedido);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}
