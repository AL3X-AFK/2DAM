
import java.time.LocalDate;

public class Calendario {
    int diaActual = 0;
    LocalDate fechaBase;

    public Calendario(LocalDate fechaBase) {
        this.fechaBase = fechaBase;
    }

    public Calendario() {
        this.fechaBase = fechaBase.now();
    }

    public synchronized void avanzarDia(){
        diaActual++;
    }

    public synchronized int getDiaActual() {
        return diaActual;
    }

    public synchronized LocalDate getFechaActual(){
        return fechaBase.plusDays(diaActual);
    }
    
}
