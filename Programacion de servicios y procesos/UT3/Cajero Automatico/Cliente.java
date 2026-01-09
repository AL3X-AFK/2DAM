import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        final String IP_SERVIDOR = "localhost";
        final int PUERTO = 12346;
        DataInputStream in;
        DataOutputStream out;

<<<<<<< HEAD
            
        try (Socket sc = new Socket(IP_SERVIDOR, PUERTO)){
            
=======
        try {
            Socket sc = new Socket(IP_SERVIDOR, PUERTO);
>>>>>>> 002bf326b11aaf3b33a0884f18791e9b5dde211c
            System.out.println("Se ha conectado al servidor en " + ": " + PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            Scanner scanner = new Scanner(System.in);


            while (true) {

                String mensaje = in.readUTF();
                System.out.println(mensaje);

                String accion = scanner.nextLine();
                out.writeUTF(accion);

                String ejecucion = in.readUTF();
                System.out.println(ejecucion);

                if (accion.equalsIgnoreCase("salir:0")) {
                    break;
                } 
            }

            sc.close();

        } catch (UnknownHostException e) {
            System.out.println("Host desconocido: " + IP_SERVIDOR);
        } catch (IOException e) {
            System.out.println("Error de I/O al conectarse: " + e.getMessage());
        }

    }
}