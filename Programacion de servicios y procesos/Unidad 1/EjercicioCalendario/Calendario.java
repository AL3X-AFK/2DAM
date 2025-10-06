package EjercicioCalendario;
import java.time.LocalDate;

public class Calendario {
    int diaActual = 0;
    LocalDate fechaBase;
    
    public Calendario() {
        this.fechaBase = LocalDate.now();
    }

    public Calendario(LocalDate fechaBase) {
        this.fechaBase = fechaBase;
    }
    
    public synchronized void avanzarDia(){
        diaActual++;
    }

    public synchronized int getDiaActual() {
        return diaActual;
    }

    public synchronized LocalDate getFechaBase() {
        return fechaBase.plusDays(diaActual);
    }

}
