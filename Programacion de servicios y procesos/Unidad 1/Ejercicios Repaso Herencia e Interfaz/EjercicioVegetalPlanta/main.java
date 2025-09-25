package EjercicioVegetalPlanta;

public class main {
    public static void main(String[] args) {
        Terreno cultivo = new Terreno();
        Hortaliza hortaliza = new Hortaliza("Zanahoria");
        Arbol arbol = new  Arbol("Manzano");

        System.out.println(cultivo.sembrar(hortaliza));
        System.out.println(cultivo.sembrar(arbol));

        System.out.println(cultivo.regar(hortaliza));
        System.out.println(cultivo.regar(arbol));
    }
    
}
