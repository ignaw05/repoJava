package herencia;

// Subclase
public class Perro extends Animal {
    private String raza;

    public Perro(String nombre, String raza) {
        super(nombre); // Llamada al constructor de la clase base
        this.raza = raza;
    }

    // redefino el toString() usando el del padre tambien
    @Override
    public String toString() {
        return super.toString() + ", herencia.Perro[raza=" + raza + "]";
    }
}