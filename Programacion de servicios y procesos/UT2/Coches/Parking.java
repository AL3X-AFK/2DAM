
import java.util.ArrayList;

public class Parking {
    private final int capacidad;
    private final ArrayList<Coche> plazas;

    public Parking(int capacidad) {
        this.capacidad = capacidad;
        this.plazas = new ArrayList<>();
    }

    public synchronized boolean entrarCoche(Coche c){
        if (capacidad > plazas.size()) {
            plazas.add(c);
            System.out.println("Coche ha entrado al parking: " + c);
            return true;
        } else{
            System.out.println("Parking lleno, no puede entrar");
            return false;
        }
    }

    public synchronized boolean salirCoche(Coche c){
        if (plazas.remove(c)) {
            System.out.println("El coche ha salido: " + c);
            return true;
        } else{
            System.out.println("El coche no ha salido");
            return false;
        }
    }

    public synchronized int plazasOcupadas(){
        return plazas.size();
    }

    public synchronized int getCapacidad(){
        return capacidad;
    }

    public void estado(){
        System.out.println("Plazas ocupadas: " + plazasOcupadas());
        System.out.println("Coches en parking: " + plazas);
    }


    public synchronized Coche obtenerPrimerCoche() {
    if (!plazas.isEmpty()) {
        return plazas.get(0);
    }
    return null;
}

}
