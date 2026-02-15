package EjercicioVegetalPlanta;

public class Terreno {
    
    public String sembrar(Vegetal v){
        return v.tipo() + " ha sido plantado";
    } 

    public String regar(Vegetal v){
        v.crecer();
        return v.tipo() + " ha sido regado";
    }
}
