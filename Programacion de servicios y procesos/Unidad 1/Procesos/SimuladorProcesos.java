public class SimuladorProcesos {

    static class ProcesoSimulado implements Runnable {
        private String nombre;

        public ProcesoSimulado(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            Thread hilo1 = new Thread(() -> ejecutarHilo("Hilo 1"));
            Thread hilo2 = new Thread(() -> ejecutarHilo("Hilo 2"));

            hilo1.start();
            hilo2.start();

            try {
                hilo1.join();
                hilo2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Proceso " + nombre + " finalizado.");
        }

        private void ejecutarHilo(String nombreHilo) {
            for (int i = 1; i <= 3; i++) {
                System.out.println(nombreHilo + " del proceso " + nombre +
                        " está en estado: " + Thread.currentThread().getState());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread procesoA = new Thread(new ProcesoSimulado("A"));
        Thread procesoB = new Thread(new ProcesoSimulado("B"));

        procesoA.start();
        procesoB.start();

        try {
            procesoA.join();
            procesoB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Simulación de todos los procesos finalizada.");
    }
}
