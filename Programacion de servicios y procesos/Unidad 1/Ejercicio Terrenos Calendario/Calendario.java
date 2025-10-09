
public class Calendario {
    
    int diaActual = 0;
    Terreno terreno;
    //LocalDate fecha;

    public Calendario(Terreno terreno){
        this.terreno = terreno;
    }

    public synchronized void avanzaDia(){
        diaActual++;
        
        Vegetal planta = terreno.getPlanta();
        
        if (planta != null) {
            planta.crecer(1);
            System.out.println(planta.estado());
        }

    }

    public synchronized int getDiaActual(){
        return diaActual;
    }
}
