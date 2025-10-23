public class Coche {
    private String matricula;

    public Coche(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public static String generarMatricula(){
        String matricula = "";
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < 4; i++) {
            int numero = (int)(Math.random()*10);
            matricula += numero;
        }
        
        matricula += "-";

        for (int i = 0; i < 3; i++) {
            int numero = (int)(Math.random()*abc.length());
                matricula += abc.charAt(numero);
        }

        return matricula;
    }

    @Override
    public String toString() {
        return "Coche [matricula=" + matricula + "]";
    }

    

}
