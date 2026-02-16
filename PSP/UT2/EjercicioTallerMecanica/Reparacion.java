package EjercicioTallerMecanica;

public class Reparacion {

    String tipo;
    int tiempo;
    double precio;
    
    
    public Reparacion(String tipo, int tiempo, double precio) {
        this.tipo = tipo;
        this.tiempo = tiempo;
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Reparacion [tipo=" + tipo + ", tiempo=" + tiempo + ", precio=" + precio + "]";
    }


    public String getTipo() {
        return tipo;
    }


    public int getTiempo() {
        return tiempo;
    }


    public double getPrecio() {
        return precio;
    }

    
    
}
