import java.util.*;

class ConteoRunnable implements Runnable{
    @Override
    public void run(){
        int n = 0;
        for (int i = 0; i < 1000000; i++) {
            n = i;
        }
        System.out.println("Fin del conteo");
    }
}


public class ejPractico1 {
    public static void main(String[] args) {
        saludar();

        Thread hilo = new Thread(new ConteoRunnable());
        hilo.start();

        despedir();
    
        try {
            hilo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void saludar(){
        System.out.println("Hola Buenos Dias");
    }
    
    static void despedir(){
        System.out.println("Nos vemos");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre");
        String x = sc.nextLine();

    }
}

