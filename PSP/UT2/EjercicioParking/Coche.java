package EjercicioParking;
import java.util.Random;

public class Coche {
    String matricula;
    Long horaEntrada;

    public Coche() {
        this.matricula = generarMatricula();
        this.horaEntrada = System.currentTimeMillis();
    }


    //Metodo de generar matricula
    public static String generarMatricula(){
        String matricula="";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random generarNumAleatorio = new Random();

        for (int i = 0; i < 4; i++) {
            int num = generarNumAleatorio.nextInt(10);
            matricula += num;
        }
        for (int i = 0; i < 3; i++) {
            int num = generarNumAleatorio.nextInt(abc.length());
            matricula += abc.charAt(num);
        }

        return matricula;
    }


    public String getMatricula() {
        return matricula;
    }


    public Long getHoraEntrada() {
        return horaEntrada;
    }

    

}
