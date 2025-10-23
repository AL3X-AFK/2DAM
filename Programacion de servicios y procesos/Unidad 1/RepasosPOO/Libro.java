public class Libro {
    private String ISBN;
    private String titulo;
    private int numeroPaginas;
    private String autor;
    private boolean prestado;
    
    public Libro() {
        this("", "", 0, "", false);
    }
    public Libro(String iSBN, String titulo, int numeroPaginas, String autor, boolean prestado) {
        ISBN = iSBN;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.prestado = prestado;
    }

    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public boolean isPrestado() {
        return prestado;
    }
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void prestar(){
        if (prestado) {
            System.out.println("Este libro ya esta prestado ");
        } else{
            prestado= true;
            System.out.println("El libro de ha prestado");
        }
    }

    public void devolver(){
        if (!prestado) {
            System.out.println("Este libro no esta prestado");
        } else {
            System.out.println("Este libro de ha devuelto");
            prestado = false;
        }
    }

    public double imprimir (double coste){
        return coste + numeroPaginas;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (ISBN == null) {
            if (other.ISBN != null)
                return false;
        } else if (!ISBN.equals(other.ISBN))
            return false;
        return true;
    }
    @Override
    public String toString() {

        String mensaje = "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", numeroPaginas=" + numeroPaginas;
        if (!this.prestado) {
            mensaje += " no esta presatado";
        } else{
        mensaje += " esta prestado ";
        }
        return mensaje;
    }

    
    public static void main(String[] args) {
        Libro libro1 = new Libro("12345", "Quijote", 150, "Cervantes", false);
        System.out.println(libro1);

        libro1.prestar();
        System.out.println(libro1);

        libro1.devolver();
        libro1.devolver();

        System.out.println(libro1);

        double costeImpresion = libro1.imprimir(0.50);

        System.out.println("El coste ha sido de :" + costeImpresion + " euros");

        Libro libro2 = new Libro("12345", "Años de soledad", 150, "Cervantes", false);

        if (libro1 == libro2) {
            System.out.println("Los libros son iguales");
        }else{
            System.out.println("Los libros no son iguales");
        }

    }

    
    
}