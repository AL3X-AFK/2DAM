class Empleado{
    String nombre;
    double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
}

class Programador extends Empleado{
    String lenguaje;

    public Programador(String lenguaje, String nombre, double salario) {
        super(nombre, salario);
        this.lenguaje = lenguaje;
    }

}
    
public class Herencia {

    
    public static void main(String[] args) {
        Programador p1 = new Programador("Java", "Alex", 2000);
        System.out.println("Su nombre: " +p1.nombre);
        System.out.println("Su salario: " +p1.salario);
        System.out.println("Su lenguaje: " +p1.lenguaje);
    }
}
