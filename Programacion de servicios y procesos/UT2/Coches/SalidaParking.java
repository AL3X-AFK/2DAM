public class SalidaParking implements Runnable{
    private final Parking parking;

    public SalidaParking(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run(){
        try {
            while (!Thread.currentThread().isInterrupted()) { 
                Thread.sleep(2000);

                if (parking.plazasOcupadas()>0) {
                    Coche cocheASalir = parking.obtenerPrimerCoche();
                    parking.salirCoche(cocheASalir);
                } else{
                    System.out.println("No hay coches a salir");
                }
                
            }
        } catch (InterruptedException e) {
        }
    }

}
