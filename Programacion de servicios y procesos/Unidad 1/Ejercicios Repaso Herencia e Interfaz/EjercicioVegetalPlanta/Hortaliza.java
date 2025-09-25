package EjercicioVegetalPlanta;

public class Hortaliza extends Planta{

    public Hortaliza(String nombre) {
        super(nombre);
    }

    @Override
    String caracteristica() {
        return "Crece rapido";
    }
    
}