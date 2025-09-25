
public class ejPractico1 {
    public static void main(String[] args) {
        saludar();
        conteo();
        despedir();
    
    }

static void saludar(){
    System.out.println("Hola Buenos Dias");
}

static void conteo(){
    for (int i = 0; i < 1000000; i++) {
        System.out.println("Contando: " + i);
    }
    System.out.println("Fin del conteo");
}

static void despedir(){
    System.out.println("Nos vemos");
}
}

