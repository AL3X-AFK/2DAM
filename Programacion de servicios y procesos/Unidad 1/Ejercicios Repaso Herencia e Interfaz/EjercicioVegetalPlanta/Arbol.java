package EjercicioVegetalPlanta;

public class Arbol extends Planta {

    public Arbol(String nombre) {
        super(nombre);
    }

    @Override
    String caracteristica() {
        return "Tiene raices profundas";
    }         
}
