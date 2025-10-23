public class h1{

    public static class hilos extends Thread{
        private String nombre;

        public hilos(String nombre){
            this.nombre = nombre;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(nombre + " dice HOLA!");
            }
        }
    }
    
    public static void main(String[] args) {
        hilos hilo1 = new hilos("Hilo 1");
        hilos hilo2 = new hilos("Hilo 2");

        hilo1.start();
        hilo2.start();


    }
    
}
