package EjercicioCalendario;

public class HiloCalendario implements Runnable{
    
    Calendario calendario;
    boolean running = true;

    public HiloCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    @Override
    public void run(){
        while (running) {
            try {
            Thread.sleep(1000);
            } catch (Exception e) {
                break;
            }
            calendario.avanzarDia();

            System.out.println("Dia: " + calendario.getDiaActual());
            System.out.println("Fecha: "  + calendario.getFechaBase());
            
        }
        System.out.println("Simulacion detenida");
    }

    public void stopCalendar(){
        running = false;
    }

    
}
