import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        //Crear terreno
        Terreno terreno1 = new Terreno();
        Terreno terreno2 = new Terreno();

        //Crear plantas
        Hortaliza manzanilla = new Hortaliza("manzanilla");
        Arbol roble = new Arbol("roble");

        terreno1.sembrar(manzanilla);
        terreno2.sembrar(roble);

        roble.regar();
        manzanilla.regar();

        Calendario cal = new Calendario(terreno1);
        HiloCalendario hilo = new HiloCalendario(cal);
        hilo.start();
        

        sc.nextLine();
    }
}
