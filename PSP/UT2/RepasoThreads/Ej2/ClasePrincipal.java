package RepasoThreads.Ej2;

public class ClasePrincipal {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new Hilo1());
        Thread hilo2 = new Thread(new Hilo2());
        Thread hilo3 = new Thread(new Hilo3());
        Thread hilo4 = new Thread(new Hilo4());

        hilo1.start();
        try {
            hilo1.sleep(10);
        } catch (InterruptedException e) {
        }

        hilo2.start();
        try {
            hilo2.sleep(10);
        } catch (InterruptedException e) {
        }

        hilo3.start();
        try {
            hilo3.sleep(10);
        } catch (InterruptedException e) {
        }

        hilo4.start();
        try {
            hilo4.sleep(10);
        } catch (InterruptedException e) {
        }
    }
}
