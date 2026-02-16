import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private static List<Block> blockchain = new ArrayList<>();
    private static final double TEMP_LIMITE = 50.0;
    private static List<RegistroTemporal> registrosIniciales = new ArrayList<>();

    public static void main(String[] args) {

        // Cargar registros antiguos desde la BD
        registrosIniciales = DatabaseService.obtenerTodosLosRegistros();

        System.out.println("Sincronización de Blockchain completada. Total de bloques: " + registrosIniciales.size());

        // Bloque Génesis
        blockchain.add(new Block("Genesis Block", "0"));

        try (ServerSocket serverSocket = new ServerSocket(6000)) {

            System.out.println("Servidor activo y escuchando en el puerto 6000...");

            while (true) {

                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String data;

                    while ((data = in.readLine()) != null) {

                        // 1 Verificar manipulación previa
                        if (hayManipulacionEnDatosAntiguos()) {
                            out.println("ALERTA: Se detectó manipulación previa de datos.");
                            return;
                        }

                        System.out.println("Datos recibidos: " + data);

                        String sensorId = data.split(";")[0];
                        String dataTemp = data.split(";")[1];
                        double temp = Double.parseDouble(dataTemp.split(":")[1]);

                        //2️ Validar integridad de la blockchain
                        if (!isChainValid()) {
                            System.err.println("ERROR GRAVE: Integridad de la Blockchain comprometida.");
                            out.println("ERROR: Integridad de la red dañada.");
                            break;
                        }

                        // 3️ Guardar en SQL
                        int idGenerado = DatabaseService.guardarLectura(sensorId, temp);

                        if (idGenerado != -1) {

                            String prevHash = blockchain.get(blockchain.size() - 1).hash;

                            String dataHash = generarDataHash(
                                    sensorId,
                                    temp,
                                    String.valueOf(idGenerado)
                            );

                            Block nuevoBloque = new Block(dataHash, prevHash);
                            blockchain.add(nuevoBloque);

                            // Vincular hash del bloque en SQL
                            DatabaseService.vincularConBlockchain(idGenerado, nuevoBloque.hash);

                            // 4️ Verificar límite crítico
                            if (temp > TEMP_LIMITE) {
                                System.err.println("ALERTA CRÍTICA: Temperatura " + temp + "°C supera el límite seguro.");
                                out.println("SISTEMA_APAGADO");
                                System.out.println("Ejecutando simulación de apagado por seguridad...");
                                return;
                            }

                            out.println("OK: Registro almacenado correctamente");
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ===============================
    // VALIDACIÓN DE CADENA
    // ===============================

    public static Boolean isChainValid() {

        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {

            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.err.println("¡ADVERTENCIA! El hash del bloque " + i + " no coincide con los datos.");
                return false;
            }

            if (!currentBlock.previousHash.equals(previousBlock.hash)) {
                System.err.println("¡ADVERTENCIA! Bloque " + i + " no está correctamente vinculado con el bloque anterior.");
                return false;
            }
        }

        return true;
    }

    // ===============================
    // HASH DE DATOS SQL
    // ===============================

    public static String generarDataHash(String sensorId, double temp, String timestamp) {

        String registroCompleto = sensorId + Double.toString(temp) + timestamp;

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(registroCompleto.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();

            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (Exception e) {
            return null;
        }
    }

    // ===============================
    // DETECCIÓN DE MANIPULACIÓN SQL
    // ===============================

    public static boolean hayManipulacionEnDatosAntiguos() {
        System.out.println("Iniciando verificación de integridad...");
        System.out.println("Cantidad de registros cargados en memoria: " + registrosIniciales.size());


        for (RegistroTemporal rt : registrosIniciales) {
            System.out.println("Verificando registro con ID: " + rt.getId());


            RegistroTemporal actual =
                    DatabaseService.obtenerRegistroPorId(rt.getId());

            if (actual == null) {

                System.err.println("\n--- ALERTA DE SEGURIDAD ---\n");
                System.err.println("El registro con ID " + rt.getId() + " ha sido eliminado de la base de datos.\n");
                System.err.println("Se desconecta el cliente debido a pérdida de integridad.");

                return true;
            }

            String hashActual = generarDataHash(
                    actual.getSensorId(),
                    actual.getValorTemp(),
                    String.valueOf(actual.getId())
            );

            if (!hashActual.equals(rt.getHashGuardado())) {

                System.err.println("\n*** ALERTA DE SEGURIDAD ***\n");

                System.err.println("El registro con ID " + rt.getId()
                        + " ha sido modificado en la base de datos.\n");

                System.err.println("Hash esperado por la Blockchain: "
                        + rt.getHashGuardado());

                System.err.println("Hash actual en SQL: "
                        + hashActual + "\n");

                System.err.println("Se desconecta el cliente por pérdida de integridad.");

                return true;
            }
        }

        return false;
    }
}
