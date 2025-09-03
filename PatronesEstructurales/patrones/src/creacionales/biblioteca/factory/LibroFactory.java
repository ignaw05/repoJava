package creacionales.biblioteca.factory;

import creacionales.biblioteca.model.Libro;
import creacionales.biblioteca.model.Autor;
import creacionales.biblioteca.model.Categoria;

public class LibroFactory implements Factory {

    @Override
    public Libro crear(String tipo) {
        if(tipo.equalsIgnoreCase("novela")) {
            return new Libro.LibroBuilder()
                    .setTitulo("Novela por defecto")
                    .setAutor(new Autor("Autor", "Desconocido", "Desconocida"))
                    .setCategoria(new Categoria("Novela", "Novelas de ficción"))
                    .build();
        } else if(tipo.equalsIgnoreCase("ciencia")) {
            return new Libro.LibroBuilder()
                    .setTitulo("Libro de ciencia")
                    .setAutor(new Autor("Ciencia", "Autor", "Desconocida"))
                    .setCategoria(new Categoria("Ciencia", "Libros de ciencia"))
                    .build();
        }
        return null;
    }
}
