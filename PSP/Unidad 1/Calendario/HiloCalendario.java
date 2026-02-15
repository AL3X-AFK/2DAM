public class HiloCalendario extends Thread {
    Calendario calendario;
    int intervaloMillis;
    volatile boolean running = true;

    public HiloCalendario(Calendario calendario, int intervaloMillis){
        this.calendario = calendario;
        this.intervaloMillis = intervaloMillis;
    }

    @Override
    public void run(){
        while (running) {
            try {
                Thread.sleep(intervaloMillis);
            } catch (InterruptedException e) {
                break;
            }
            calendario.avanzarDia();
            System.out.println("Dia: "+ calendario.getDiaActual());
            System.out.println("Fecha: " + calendario.getFechaActual());
        }
        System.out.println("Simulacion detenida.");
    }

    public void stopCalendar(){
        running = false;
        this.interrupt();
    }

    
}
