package RepasoThreads.Ej1;

public class HiloProceso implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
        
    }
}
