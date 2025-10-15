public class HiloCalendario extends  Thread{

    Calendario calendario;
    Boolean running = true;

    public HiloCalendario(Calendario calendario) {
        this.calendario = calendario;
    }

    @Override
    public void run(){
        while (running) {
            
            calendario.avanzaDia();
            try {
            Thread.sleep(2000);
            } catch (Exception e) {
                break;
            }

        }
    }

    public void stopCalendar(){
        running = false;
        this.interrupt();
    }
}
