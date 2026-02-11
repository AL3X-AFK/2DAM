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
            System.out.println("Conectado al servidor en " + remoteIP + ":" + PORT);

             while (true) {
                System.out.println("Ingrese temperatura actual:");
                double temp = sc.nextDouble();
                out.println(SENSOR_ID + ";" + "TEMP:" + temp);

                String respuesta = in.readLine();
                if (respuesta.equals("SISTEMA_APAGADO")) {
                    System.out.println("El servidor ha ordenado el apagado del equipo");
                    break;
                } else {
                    System.out.println("RESPUESTA:" + respuesta);
                }
            }
                } catch (IOException e) {
                    System.out.println("Por favor, ingresa un número válido o 'SALIR'.");
                }
    }
}
