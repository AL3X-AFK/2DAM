import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Cliente {
    
    public static void main(String[] args) {
        
        final String HOST = "localhost";
        final int PUERTO = 1234;
        DataInputStream in;
        DataOutputStream out;
        
        try {
            Socket sc = new Socket(HOST, PUERTO);

            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());

            out.writeUTF("¡Hola mundo desde el cliente!");

            String mensaje = in.readUTF();
            
            System.out.println(mensaje);

            sc.close();

        } catch (Exception e) {
        }
    }
}
