
public class Arbol extends Planta {

    public Arbol(String nombre) {
        super(nombre);
    }

    @Override
    int consumoDiarioAgua(){
        int consumo = 6;
        aguaDisponible -= consumo;
        return aguaDisponible;
    }

    @Override
    public void crecer(int dias) {
        altura += dias;
    }

    @Override
    public String estado() {
        return "Tipo: " +tipo() +", Nombre: " + nombre+", Altura: "+altura+", Agua disponible: "+consumoDiarioAgua();

    }

    @Override
    public String tipo() {
        return "Roble";
    }
}
