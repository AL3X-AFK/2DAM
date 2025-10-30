
import java.time.LocalDateTime;
import java.util.Random;

public class Mensaje {

    String mensaje;
    tipoDeMensaje tipo;
    LocalDateTime fecha;

    public enum tipoDeMensaje{
            Info,
            Error,
            Warning
        }

    public Mensaje() {
        this.mensaje = generarMensaje();
        this.tipo = tipoAleatorio();
        this.fecha = LocalDateTime.now();
    }

    public static String generarMensaje(){
        String mensaje = "";
        String[] palabras = {"hola", "como", "te", "llamas", "hasta", "luego", "random"};
        Random random = new Random();
        int numPalabras = random.nextInt(10);

        for (int i = 0; i < numPalabras; i++) {
            int indiceRandom = random.nextInt(palabras.length);
            mensaje += palabras[indiceRandom] + " ";
        }
        return mensaje.trim();
    }


    public static tipoDeMensaje tipoAleatorio(){
        Random random = new Random();
        tipoDeMensaje[] tipos = tipoDeMensaje.values();       
        int indiceRandom = random.nextInt(tipos.length);
        return tipos[indiceRandom];
    }

    public String getMensaje() {
        return mensaje;
    }

    public tipoDeMensaje getTipo() {
        return tipo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    
}
