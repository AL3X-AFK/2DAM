
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class map {

    private static void rellenarArray() {
        ArrayList<int[]> personas = new ArrayList<int[]>();

        int maxPersonas = 30;

        for (int i = 0; i < maxPersonas; i++) {
            int[] computoEdades = new int[2];

            int edad = (int) ((Math.random() * 3) + 18);
            computoEdades[0] = edad;
            computoEdades[1] = 1;

            if (personas.size() != 0) {

                try {
                    boolean add = true;

                    for (int[] persona : personas) {
                        if (persona[0] == edad) {
                            persona[1]++;
                            add = false;
                            break;
                        }
                    }
                    if (add) {
                        personas.add(computoEdades);
                    }

                } catch (Exception e) {
                }

            } else {
                personas.add(computoEdades);
            }
            for (int[] persona : personas) {
                System.out.println(persona[0] + ": " + persona[1]);
            }
        }
    }

    public static void rellenaMap() {
        Map<Integer, Integer> personas = new ConcurrentHashMap<>();

        int maxPersonas = 30;

        for (int i = 0; i < maxPersonas; i++) {
            int edad = (int) ((Math.random() * 3) + 18);
            personas.put(edad, personas.getOrDefault(edad, 0) + 1);
        }

        System.out.println(personas);
    }

    public static void renderGrade(Double nota) {
        System.out.printf("%.2f\n", nota);
    }

    public static void main(String[] args) {

        String nombres[] = { "Luis", "Martin", "Marta", "Gabriel", "Julia" };
        String[] asignaturas = { "Lengua", "Mates", "Fisica" };

        Map<String, Map<String, Double>> notas = new HashMap<>();

        for (String asignatura : asignaturas) {
            for (String persona : nombres) {
                double nota = (double) Math.random() * 10;

                Map<String, Double> notasPersonas = notas.getOrDefault(persona, new HashMap<String, Double>());
                notasPersonas.put(asignatura, notasPersonas.getOrDefault(asignatura, null));
                notas.put(persona, notasPersonas);
            }
        }

        for (Map.Entry<String, Map<String, Double>> persona : notas.entrySet()) {
            String nombrePersona = persona.getKey();
            Map<String, Double> notasPersona = persona.getValue();
            for (Map.Entry<String, Double> nota : notasPersona.entrySet()) {
                String nombreAsignatura = nota.getKey();
                Double notasAsignatura = nota.getValue();
                System.out.println("nombre: " + nombrePersona + " en " + nombreAsignatura);
            }            
        }
    }
}
