package creacionales.biblioteca.model;

public class Prestamo implements Cloneable {
    private int id;
    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;

    public Prestamo(int id, Usuario usuario, Libro libro, String fechaPrestamo) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
    }

    @Override
    public Prestamo clone() throws CloneNotSupportedException {
        return (Prestamo) super.clone();
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", libro=" + libro +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                '}';
    }
}
