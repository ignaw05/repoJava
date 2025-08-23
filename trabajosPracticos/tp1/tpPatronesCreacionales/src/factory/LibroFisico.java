package main.java.factory;

public class LibroFisico extends Libro{

    public LibroFisico(String titulo, String autor, int precio) {
        super(titulo, autor, precio);
    }

    @Override
    public void leerDatos() {
        System.out.println("El libro "+this.getTitulo()+" ($"+this.getPrecio()+") es de " + this.getAutor() + " y es físico");
    }
}