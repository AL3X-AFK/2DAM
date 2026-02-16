package UT3.ClienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    private static final int PUERTO = 12345;
    public static void main(String[] args) {
        
        try (
            ServerSocket serverSocket = new ServerSocket(PUERTO);
        ){
            System.out.println("Servidor iniciado. Esperando conexion en el puerto: " + PUERTO + "...");

            //1- Esperar y aceptar la conexion del cliente (Bloqueante)
            //Se queda esperando hasta que un cliente se conecta

            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde: " + clienteSocket.getInetAddress());

            //2- Obtener los streams de comunicacion
            //Se usan para enviar (Output) y recibir(input) datos.
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true); //'true' para autoflush

            String mensajeCliente;

            while ((mensajeCliente = entrada.readLine()) != null) {
                System.out.println("Mensaje recibido del cliente: " + mensajeCliente);

                //Enviar una respuesta al cliente
                String respuesta = "ECHO: " + mensajeCliente.toUpperCase();
                salida.println(respuesta);

                if (mensajeCliente.equalsIgnoreCase("FIN")) {
                    break;
                }
            }

            //4- Cerrar sockests y streams
            System.out.println("Cerrando conexion con el servidor");
            clienteSocket.close();
            
        } catch (IOException e) {
            System.out.println("Error en el servidor " + e.getMessage());
        }
    }
}
