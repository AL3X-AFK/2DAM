package control1.Alex.Valdez;

import java.util.ArrayList;

public class Pedido {
    int idMesa;
    ArrayList<Plato> platos;
    double total;

    public Pedido(ArrayList<Plato> platos, double total) {
        this.platos = platos;
        this.total = total;
    }
}
