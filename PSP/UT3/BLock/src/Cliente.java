import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    private static final String remoteIP = "localhost";
    private static final int PORT = 6000;
    private static final String SENSOR_ID = "SENSOR_VALLE_01";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (
            Socket socket = new Socket(remoteIP, PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // auto-flush
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("Conexión establecida con el servidor " + remoteIP + ":" + PORT);

            while (true) {
                System.out.print("Por favor, ingresa la temperatura actual: ");
                double temp = sc.nextDouble();
                out.println(SENSOR_ID + ";" + "TEMP:" + temp);

                String respuesta = in.readLine();
                if (respuesta.equals("SISTEMA_APAGADO")) {
                    System.out.println("El servidor ha solicitado apagar el equipo.");
                    break;
                } else {
                    System.out.println("Respuesta del servidor: " + respuesta);
                }
            }
        } catch (IOException e) {
            System.out.println("Error de comunicación. Asegúrate de ingresar un número válido.");
        }
    }
}
