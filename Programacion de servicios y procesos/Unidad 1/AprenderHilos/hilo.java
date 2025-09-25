class Mitarea implements Runnable {
    @Override
    public void run(){
        System.out.println("Hilo en ejecucion con runnable");
    }
    
}
public class hilo {
    public static void main(String[] args) {
        Thread h1 = new Thread(new Mitarea());
        h1.start();
    }
}
