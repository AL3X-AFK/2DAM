package RepasoThreads.Ej1;

public class Main {
    public static void main(String[] args) {
        
        HiloProceso h1 = new HiloProceso();
    
        Thread hilo1 = new Thread(h1);
        Thread hilo2 = new Thread(h1);
        hilo1.start();
    
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Error " + e);
        }

        hilo2.start();
        hilo2.stop();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            
        }
    }
}