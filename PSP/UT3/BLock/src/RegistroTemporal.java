public class RegistroTemporal {

    private int id;
    private String sensorId;
    private double valorTemp;
    private String hashGuardado;

    public RegistroTemporal(int id, String sensorId, double valorTemp, String hashGuardado) {
        this.id = id;
        this.sensorId = sensorId;
        this.valorTemp = valorTemp;
        this.hashGuardado = hashGuardado;
    }

    public int getId() {
        return id;
    }

    public String getSensorId() {
        return sensorId;
    }

    public double getValorTemp() {
        return valorTemp;
    }

    public String getHashGuardado() {
        return hashGuardado;
    }
}
