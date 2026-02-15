public abstract class Planta implements  Vegetal{
    String nombre;
    int altura;
    int aguaDisponible;

    public Planta(String nombre){
        this.nombre = nombre;
    }

    @Override
    public void regar() {
       aguaDisponible = 100;
    }

    abstract int consumoDiarioAgua();


    public int getAltura() {
        return altura;
    }

    public int getAguaDisponible() {
        return aguaDisponible;
    }

    public String getNombre(){
        return nombre;
    }
    
}
