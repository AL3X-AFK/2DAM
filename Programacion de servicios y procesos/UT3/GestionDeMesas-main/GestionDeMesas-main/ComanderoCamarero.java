
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ComanderoCamarero implements Runnable{

    private final Socket clienteSocket;
    private final GestorMesas gestorMesas;

    public ComanderoCamarero(Socket clienteSocket, GestorMesas gestorMesas){
        this.clienteSocket=clienteSocket;
        this.gestorMesas=gestorMesas;
    }

    @Override
    public void run() {
        try(
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(),true);
            Socket socket = clienteSocket;
        ){
            String ordenCliente;
            while((ordenCliente = entrada.readLine()) != null){
                System.out.println("Recibido:"+ordenCliente); // SENTAR;6 || LEVANTAR;1
                String respuesta = procesarOrden(ordenCliente);
                salida.println(respuesta);
            }

        }catch(Exception e){

        }
    }

    private String procesarOrden(String ordenCliente){
        String partes[] = ordenCliente.split(";");
        String comando = partes[0];
        String parametro = partes[1];

        switch (comando) {
            case "SENTAR":
                int mesaAsignada = gestorMesas.asignarMesa();
                if(mesaAsignada != -1){
                    return "OK;MESA ASIGNADA:"+mesaAsignada;
                }else{
                    return "ERROR;NINGUNA MESA LIBRE";
                }
            case "LEVANTAR":
                try {
                    int numeroMesa = Integer.parseInt(parametro);
                    boolean liberada = gestorMesas.liberarMesa(numeroMesa);
                    if(liberada){
                        return "OK;MESA LIBERADA";
                    }else{
                        return "ERROR;LA MESA YA ESTABA VACÍA";
                    }
                } catch (Exception e) {
                    return "PARAMETRO INVALIDO";
                }
            default:
                return "ERROR DEL COMANDO";
        }
    }
}
