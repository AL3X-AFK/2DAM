
public class Hortaliza extends Planta{
    
    public Hortaliza(String nombre){
        super(nombre);
    }

    @Override
    int consumoDiarioAgua(){
        return 3;
    }

    public boolean viva() {
    return aguaDisponible > 0;
}

    @Override
    public void crecer(int dias) {
        if (!viva()) return;
        for (int i = 0; i < dias; i++) {
            aguaDisponible -= consumoDiarioAgua();
            if (aguaDisponible > 0) altura += 2;
            else {
                System.out.println(nombre + " se ha secado");
                break;
            }
        }
    }

    @Override
    public String estado() {
        return "Tipo: " +tipo() +", Nombre: " + nombre+", Altura: "+altura+", Agua disponible: "+aguaDisponible;

    }

    @Override
    public String tipo() {
        return "Hortaliza";
    }   

   
}
