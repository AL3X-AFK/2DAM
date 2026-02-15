
import java.time.LocalDate;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendario calendario;
        

        System.out.println("Introduce la fecha (yyyy/mm/ddd) o pulsa enter: ");
        String fecha = sc.nextLine();

        if (fecha.isEmpty()) {
            calendario = new Calendario();
            System.out.println("Calendario con fecha actual: " + LocalDate.now());
        } else {
            try {
                LocalDate fechaBase = LocalDate.parse(fecha);
                calendario = new Calendario(fechaBase);
                System.out.println("Fecha configurada: " + fechaBase);
            } catch (Exception e) {
                System.out.println("Formato no valido");
                calendario = new Calendario();

            }
        }

        HiloCalendario hilo = new HiloCalendario(calendario, 1000);
        hilo.start();

        System.out.println("Para parar presione ENTER");
        sc.nextLine();
        hilo.stopCalendar();
        sc.close();
    }
}
