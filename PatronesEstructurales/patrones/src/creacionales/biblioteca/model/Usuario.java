package creacionales.biblioteca.model;

public class Usuario {
    private String nombre;
    private String email;
    private String tipo;

    public Usuario(String nombre, String email, String tipo) {
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - " + email;
    }
}
