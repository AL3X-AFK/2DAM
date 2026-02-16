package UT3.ClienteServidor;

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
            System.out.println("Conectado al servidor en " + IP_SERVIDOR + ": " + PUERTO);

            String mensajeUsuario;
            String respuestaServidor;

            //3- Logica de comunciacion (envio y recepcion)
            do{
                System.out.println("Ingrese el mensaje (o FIN para terminar): ");
                mensajeUsuario = scanner.nextLine();

                //Enviar mensaje al servidor
                salida.println(mensajeUsuario);

                //Recibir la respuesta del servidor
                respuestaServidor = entrada.readLine();
                System.out.println("Servidor dice: " + respuestaServidor);

            } while(!mensajeUsuario.equalsIgnoreCase("FIN"));

        } catch (UnknownHostException e) {
            System.out.println("Host desconocido: " + IP_SERVIDOR);
        } catch (IOException e){
            System.out.println("Error de I/O al conectarse: " + e.getMessage());
        }
    }
}
