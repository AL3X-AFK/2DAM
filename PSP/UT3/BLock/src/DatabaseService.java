import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    // Configuración LOCAL
    private static final String IP = "localhost";
    private static final String DB = "sistema_monitoreo";
    private static final String URL =
            "jdbc:mysql://" + IP + ":3306/" + DB +
            "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String USER = "alex";
    private static final String PASS = "1234";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontró el driver de MySQL.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    /**
     * Inserta la lectura y devuelve el ID generado para poder hashearlo
     * después.
     */
    
    public static int guardarLectura(String sensorId, double temp) {

        String sql = "INSERT INTO lecturas_temperatura (sensor_id, valor_temp) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, sensorId);
            pstmt.setDouble(2, temp);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            System.err.println("Error al guardar en BD: " + e.getMessage());
        }

        return -1;
    }

     /**
     * Actualiza la fila con el hash del bloque de la Blockchain.
     */
    
    public static void vincularConBlockchain(int idRegistro, String blockHash) {

        String sql = "UPDATE lecturas_temperatura SET blockchain_hash = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, blockHash);
            pstmt.setInt(2, idRegistro);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error al vincular con Blockchain: " + e.getMessage());
        }
    }

    public static RegistroTemporal obtenerRegistroPorId(int id) {

        String sql = """
            SELECT id, sensor_id, valor_temp
            FROM lecturas_temperatura
            WHERE id = ?
        """;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new RegistroTemporal(
                        rs.getInt("id"),
                        rs.getString("sensor_id"),
                        rs.getDouble("valor_temp"),
                        null
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<RegistroTemporal> obtenerTodosLosRegistros() {

        List<RegistroTemporal> lista = new ArrayList<>();

        String sql = """
            SELECT id, sensor_id, valor_temp
            FROM lecturas_temperatura
            WHERE blockchain_hash IS NOT NULL
            ORDER BY id ASC
        """;

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("id");
                String sensorId = rs.getString("sensor_id");
                double temp = rs.getDouble("valor_temp");

                String hashRecalculado = Servidor.generarDataHash(sensorId, temp, String.valueOf(id));
                lista.add(new RegistroTemporal(id, sensorId, temp, hashRecalculado));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
