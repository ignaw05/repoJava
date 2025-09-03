package creacionales.biblioteca.model;

public class Libro {
    private String titulo;
    private String isbn;
    private Autor autor;
    private Categoria categoria;
    private int anioPublicacion;

    private Libro(LibroBuilder builder) {
        this.titulo = builder.titulo;
        this.isbn = builder.isbn;
        this.autor = builder.autor;
        this.categoria = builder.categoria;
        this.anioPublicacion = builder.anioPublicacion;
    }

    public static class LibroBuilder {
        private String titulo;
        private String isbn;
        private Autor autor;
        private Categoria categoria;
        private int anioPublicacion;

        public LibroBuilder setTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public LibroBuilder setIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public LibroBuilder setAutor(Autor autor) {
            this.autor = autor;
            return this;
        }

        public LibroBuilder setCategoria(Categoria categoria) {
            this.categoria = categoria;
            return this;
        }

        public LibroBuilder setAnioPublicacion(int anio) {
            this.anioPublicacion = anio;
            return this;
        }

        public Libro build() {
            return new Libro(this);
        }
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor=" + autor +
                ", categoria=" + categoria +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }
}
