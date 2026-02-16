import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    static double saldo = 1000;

    public static void main(String[] args) {
        Socket sc = null;
        final int PUERTO = 12346;



        try (ServerSocket servidor = new ServerSocket(PUERTO)){
            System.out.println("Servidor iniciado. Esperando conexion en el puerto: " + PUERTO + "...");

            while (true) {
                sc = servidor.accept();
                System.out.println("Cliente conectado desde: " + sc.getInetAddress());

                Thread hilo = new Thread(new clienteHandler(sc));

                hilo.start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor " + e.getMessage());
        }
    }

    static synchronized String accionDelBanco(String accion){
        String[] array = accion.split(":");
        String palabra = array[0];
        String cantidad = array[1];

        if (palabra.equalsIgnoreCase("Consultar")) {
            return("OK:Saldo actual es: " + String.valueOf(saldo) + "$");
        } else if (palabra.equalsIgnoreCase("Ingresar")){
            saldo = saldo + Double.parseDouble(cantidad);
            return("OK:Ingreso realizado. Nuevo saldo: " +String.valueOf(saldo) + "$");            
        } else if(palabra.equalsIgnoreCase("Retirar")){
            if (saldo >= Double.parseDouble(cantidad) ) {
                saldo = saldo - Double.parseDouble(cantidad);
                return("OK:Retirada con éxito " + String.valueOf(saldo) + "$");
            } else {
                return("ERROR:Saldo insuficiente");
            }
             
        } else{
            return("ADIOS:Gracias por su visita");
        }
    }   
}


class clienteHandler implements Runnable {
    
    Socket sc;

    public clienteHandler(Socket sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            String accion;

            while (true) {
                out.writeUTF("----------\n*QUE DESEA HACER?*\nConsultar:0\nIngresar:X\nRetirar:X\nSalir:0");

                accion = in.readUTF();
                System.out.println("La accion del cliente es: " + accion);

                out.writeUTF(Servidor.accionDelBanco(accion));

                if (accion.equalsIgnoreCase("salir:0")) {
                    break;
                }
            }

            sc.close();

        } catch (IOException e) {
            System.out.println("Error en el servidor " + e.getMessage());
        }

    }
    
}