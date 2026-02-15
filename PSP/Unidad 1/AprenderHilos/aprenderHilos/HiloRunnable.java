package aprenderHilos;

public class HiloRunnable implements Runnable{
    
    @Override
    public void run(){
        
        try {
            System.out.println("Este es el hilo con Runnable");
           Thread.sleep(4000); 
           System.out.println("Adios");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
