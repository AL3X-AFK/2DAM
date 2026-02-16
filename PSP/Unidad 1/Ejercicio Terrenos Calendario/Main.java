import java.util.*;

public class Main {
    public static void main(String[] args) {
        
         Scanner sc = new Scanner(System.in);

        //Crear terrenos
        Terreno terreno1 = new Terreno();
        Terreno terreno2 = new Terreno();

        //Crear plantas
        Hortaliza tomate = new Hortaliza("Tomate");
        Arbol roble = new Arbol("Roble");

        //Sembrar
        terreno1.sembrar(tomate);
        terreno2.sembrar(roble);

        //Regar al inicio
        tomate.regar();
        roble.regar();

        //Crear lista de terrenos
        List<Terreno> terrenos = new ArrayList<>();
        terrenos.add(terreno1);
        terrenos.add(terreno2);

        //Crear calendario e hilo
        Calendario calendario = new Calendario(terrenos);
        HiloCalendario hilo = new HiloCalendario(calendario);
        hilo.start();

        
        System.out.println("Simulación iniciada.");
        System.out.println("Pulsa [ENTER] en cualquier momento para regar todas las plantas.");
        

        //Esperar ENTER para regar todas las plantas
        while (true) {
            sc.nextLine();
            System.out.println("Regando todas las plantas...");
            for (Terreno t : terrenos) {
                if (t.getPlanta() != null) {
                    t.getPlanta().regar();
                }
            }
        }

    }
}