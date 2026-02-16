interface Volador {
    void volar();
}

class Pajaro implements Volador{

    @Override
    public void volar(){
        System.out.println("El pajaro esta volando");
    }
    
}
class Avion implements Volador{
    @Override
    public void volar(){
        System.out.println("El avion esta despegando");
    }
}
public class Interfaz {
    public static void main(String[] args) {
        
        Volador[] voladores = {new Pajaro(), new Avion()};
        
        for (Volador volador : voladores) {
            volador.volar();
        }
    }
}
