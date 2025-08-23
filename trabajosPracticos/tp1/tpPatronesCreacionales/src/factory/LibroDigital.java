package main.java.factory;

public class LibroDigital extends Libro{

    public LibroDigital(String titulo, String autor, int precio) {
        super(titulo, autor, precio);
    }

    @Override
    public void leerDatos() {
        System.out.println("El libro "+this.getTitulo()+" ($"+this.getPrecio()+") es de " + this.getAutor() + " y es digital");
    }
}
