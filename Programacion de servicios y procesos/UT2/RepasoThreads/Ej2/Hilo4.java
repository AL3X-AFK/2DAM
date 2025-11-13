package RepasoThreads.Ej2;

public class Hilo4 implements Runnable{
    
    @Override
    public void run() {
        for(int i = 0; i<11; i++){
            System.out.println("K");


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        }
    }
}
