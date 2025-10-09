
public class Hortaliza extends Planta{
    
    public Hortaliza(String nombre){
        super(nombre);
    }

    @Override
    int consumoDiarioAgua(){
        int consumo = 3;
        aguaDisponible -= consumo;
        return aguaDisponible;
    }

    @Override
    public void crecer(int dias) {
        altura += dias*2;
    }

    @Override
    public String estado() {
        return "Tipo: " +tipo() +", Nombre: " + nombre+", Altura: "+altura+", Agua disponible: "+consumoDiarioAgua();
    }

    @Override
    public String tipo() {
        return "Hortaliza";
    }   

   
}
