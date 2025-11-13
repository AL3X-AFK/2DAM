package RepasoThreads.Ej2;

public class Hilo2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i<11; i++){
            System.out.print("E");
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
        
        }
        
    }
}
