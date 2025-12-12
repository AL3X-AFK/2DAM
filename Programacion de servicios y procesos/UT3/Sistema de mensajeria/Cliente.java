import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    private static final String IP_SERVIDOR = "localhost"; // o la ip del servidor
    private static final int PUERTO = 12345;

    public static void main(String[] args) {
        System.out.println("***Ingrese su nombre:");
        Scanner sc = new Scanner(System.in);
        String nombreCliente = sc.nextLine();

        try (
            //1- Intentar establecer conexion con el servidor
            Socket socket = new Socket(IP_SERVIDOR,PUERTO);

            //2- Obtener los streams de comunicacion
            //Para enviar datos al servidor
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            
            //Para leer la resppuesta del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //Para leer la entrada del usuario por consola
            Scanner scanner = new Scanner(System.in);
        ){
            System.out.println(nombreCliente + " se ha conectado al servidor en " + ": " + PUERTO);

        } catch (UnknownHostException e) {
            System.out.println("Host desconocido: " + nombreCliente);
        } catch (IOException e){
            System.out.println("Error de I/O al conectarse: " + e.getMessage());
        }
        sc.close();
    }
}
