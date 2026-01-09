import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {
    public static void main(String[] args) {
        final int PUERTO = 1234;
        Socket sc;

        int segundos = 3;

        List<PrintWriter> escritoresClientes = new ArrayList<>();

        
        try (ServerSocket servidor = new ServerSocket(PUERTO)){
            System.out.println("Servidor iniciado, esperando conexion...");
            
            while (true) { 
                sc = servidor.accept();
                

                System.out.println("Cliente conectado desde: " + sc.getInetAddress());
                    


            }
            
        } catch (IOException e) {
        }
    }
}



class jugadores implements Runnable{

    Socket sc;

    public jugadores(Socket sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            out.writeUTF("Ingrese su nombre");

            String nombreJugador = in.readUTF();
            System.out.println("Usuario nuevo: " + nombreJugador);
        } catch (IOException e) {
        }
    }
    
}
