package main.java.factory;

public class LibroDigital extends Libro{
    private String titulo;

    @Override
    void leer() {
        System.out.println("El titulo es '" + titulo + "' y es digital");
    }
}
