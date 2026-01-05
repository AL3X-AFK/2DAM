import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {


        ServerSocket servidor = null;
        Socket sc = null;
        final int PUERTO = 1234;

        DataInputStream in;
        DataOutputStream out;


        try {
            servidor = new ServerSocket(PUERTO); 
            System.out.println("Servidor iniciado...");
            
            while (true) {

                sc = servidor.accept();
                System.out.println("CLiente conectado...");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();
                System.out.println(mensaje);

                out.writeUTF("Hola mundo desde el servidor");

                sc.close();

                System.out.println("CLiente desconectado...");

            }


        } catch (Exception e) {
             
        }
    }
}
