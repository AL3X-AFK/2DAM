
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    
    public static void main(String[] args) {
        
        final int PUERTO = 1234;
        final String IP ="localhost";

        Scanner scanner = new Scanner(System.in);

        try (Socket sc = new Socket(IP, PUERTO)){
            
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            System.out.println("Conectado al servidor correctamente");
            System.out.println(in.readUTF());

            String nombre = scanner.nextLine();
            out.writeUTF(nombre);
            
        } catch (Exception e) {
        }
        
    }
}
