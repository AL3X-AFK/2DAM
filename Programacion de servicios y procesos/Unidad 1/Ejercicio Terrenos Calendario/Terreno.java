
public class Terreno {
    Vegetal planta;

    void sembrar(Vegetal v){
        planta = v;
        System.out.println("Sembado: " + ((Planta)v).getNombre());
    }

    void mostrarEstado(){
        if(planta!=null){
            System.out.println(planta.estado());
        } else {
            System.out.println("No hay planta sembrada");
        }
    }

    public Vegetal getPlanta() {
        return planta;
    }

    
}
