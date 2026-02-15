package EjercicioVegetalPlanta;

//Clase abstracta Planta
public abstract class Planta implements Vegetal {

    private String nombre;

    public Planta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void crecer() {
    }

    @Override
    public String tipo() {
        return this.getClass().getSimpleName() + " de: " + this.getNombre() + " "+this.caracteristica();
    }
    
    abstract String caracteristica();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
