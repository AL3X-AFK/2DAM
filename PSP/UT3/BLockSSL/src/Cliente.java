import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Cliente {

    private static final String remoteIP = "localhost";
    private static final int PORT = 6000;
    private static final String SENSOR_ID = "SENSOR_VALLE_01";

    public static void main(String[] args) throws Exception {

        // Configurar truststore
        System.setProperty("javax.net.ssl.trustStore", "src/clienttruststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 6000);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner sc = new Scanner(System.in)) {

            System.out.println("Conectado al servidor mediante SSL.");

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
