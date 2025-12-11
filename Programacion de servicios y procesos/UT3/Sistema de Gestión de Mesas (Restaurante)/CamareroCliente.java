
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CamareroCliente {
    
    private static final String IP_SERVIDOR = "localhost";
    private static final int PUERTO = 55555;

    public static void main(String[] args) {

        try (
            //1.- Intentar establecer conexion con el servidor
            Socket socket = new Socket(IP_SERVIDOR, PUERTO);

            // 2.- Obtener los streams de cominnocaciob
            //Enviar datos al servidor
            PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
            //Leer respuesta del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //Leer la entrada por consola del usuario
            Scanner scanner = new Scanner(System.in);
        ){
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
                    case 1: //Sentar
                        System.out.println("Cuantos comensales?");
                        int comensales = scanner.nextInt();
                        scanner.nextLine();
                        ordenEnvio = "SENTAR;" + comensales;
                        break;

                    case 2: //Levantar
                        System.out.println("Que mesa se levanta?");
                        int numeroMesa = scanner.nextInt();
                        scanner.nextLine();
                        ordenEnvio = "LEVANTAR;" + numeroMesa;
                        break; 

                    case 3://Salir
                        ejecutando = false;
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }

                if (!ordenEnvio.isEmpty()) {
                    salida.println(ordenEnvio);

                    String respuestaServidor = entrada.readLine();
                    procesarRespuesta(respuestaServidor);
                }

            }
            

        } catch (UnknownHostException e) {
            System.out.println("Host desconocido: " + IP_SERVIDOR);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void mostrarMenu(){
        System.out.println("-----Sistema camarero-----");
        System.out.println("1. Sentar Mesa------------");
        System.out.println("2. Levantar Mesa----------");
        System.out.println("3. Salir------------------");
        System.out.println("Seleccione una opcion");
    }


    public static void procesarRespuesta(String respuestaServidor){
        System.out.println(respuestaServidor);
    }
}
