
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CamareroCliente {

    private static final String IP_SERVIDOR = "localhost";
    private static final int PUERTO = 55555;

    public static void main(String[] args) {
        try (
                Socket socket = new Socket(IP_SERVIDOR, PUERTO); 
                PrintWriter salida = new PrintWriter(socket.getOutputStream(), true); 
                BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                Scanner scanner = new Scanner(System.in);
            ) {

            boolean ejecutando = true;
            while (ejecutando) {
                mostrarMenu();
                if (!scanner.hasNextInt()) {
                    System.out.println("Entrada invalida");
                    scanner.next();
                    continue;
                }
                int opcion = scanner.nextInt();

                String ordenEnvio = "";

                switch (opcion) {
                    case 1: // Sentar
                        System.out.println("¿Cuantos comensales?");
                        int comensales = scanner.nextInt();
                        ordenEnvio = "SENTAR;" + comensales;
                        break;
                    case 2: // Levantar
                        System.out.println("¿Que mesa se levanta?");
                        int numeroMesa = scanner.nextInt();
                        ordenEnvio = "LEVANTAR;" + numeroMesa;
                        break;
                    case 3: // Salir
                        ejecutando = false;
                        break;
                    default:
                        System.err.println("Opcion no valida");
                }
                if (!ordenEnvio.isEmpty()) {
                    salida.println(ordenEnvio);

                    String respuestaServidor = entrada.readLine();
                    procesarRespuesta(respuestaServidor);
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + IP_SERVIDOR);
        } catch (IOException e) {
            System.err.println("Error de I/O al conectarse: " + e.getMessage());
        }
    }

    public static void procesarRespuesta(String respuestaServidor) {
        System.out.println(respuestaServidor);
    }

    public static void mostrarMenu() {
        System.out.println("----Sistema Camarero----");
        System.out.println("1.Sentar Mesa (Asignar)");
        System.out.println("2.Levantar Mesa (Liberar)");
        System.out.println("3.Salir");
        System.out.println("Seleccione una opcion:");

    }
}
