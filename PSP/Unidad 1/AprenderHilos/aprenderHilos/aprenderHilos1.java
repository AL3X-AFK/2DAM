package aprenderHilos;
public class aprenderHilos1 {
    public static void main(String[] args) {
        hilo hilo1 = new hilo();
        Thread hilo2 = new Thread(new HiloRunnable());


        hilo1.start();
        hilo2.start();

    }
}
