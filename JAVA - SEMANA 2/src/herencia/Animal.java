package herencia;

// Clase base
public class Animal {
    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    // redefino el toString()
    @Override
    public String toString() {
        return "herencia.Animal[nombre=" + nombre + "]";
    }
}