package EjercicioCalendario;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendario calendario;
        
        System.out.println("Ingrese la fecha que desea o presione enter: ");
        String fecha = sc.nextLine();

        if (fecha.isEmpty()) {
            calendario = new Calendario();
            System.out.println("Calendario con fecha actual: " + LocalDate.now());
        } else{
            try {
                LocalDate fechaBase = LocalDate.parse(fecha);
                calendario = new Calendario(fechaBase);
            } catch (Exception e) {
                System.out.println("Valor invalido");
                calendario = new Calendario();
                System.out.println("Calendario con fecha actual: " + LocalDate.now());
            }
        }

        Thread hilo = new Thread(new HiloCalendario(calendario));

        hilo.start();

        System.out.println("Presione ENTER para parar la simulacion");
        sc.nextLine();
        hilo.interrupt();        
        sc.close();

    }
}
