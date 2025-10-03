public class HiloCalendar extends Thread{
    Calendario calendario;
    int milisegundos;
    volatile boolean running = true;

    public HiloCalendar(Calendario calendario, int milisegundos){
        this.calendario = calendario;
        this.milisegundos = milisegundos;
    }

    @Override
    public void run(){
        while (running) {
            try {
                Thread.sleep(milisegundos);
            } catch (InterruptedException e) {
                break;
            }
            System.out.println("Dia: " + calendario.getDiaActual());
        }
    }

}
