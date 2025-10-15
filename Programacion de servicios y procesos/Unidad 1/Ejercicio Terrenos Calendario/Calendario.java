import java.util.*;

public class Calendario {
    
    int diaActual = 0;
    List<Terreno> terrenos;
    //LocalDate fecha;

    public Calendario(List<Terreno> terrenos){
        this.terrenos = terrenos;
    }

    public synchronized void avanzaDia(){
        diaActual++;
        System.out.println("= Dia " + diaActual + " = ");

        for(Terreno t: terrenos){
            Vegetal planta = t.getPlanta();
            if (planta != null ) {
                planta.crecer(1);
                System.out.println(planta.estado());
            }
        }
        

    }

    public synchronized int getDiaActual(){
        return diaActual;
    }
}
