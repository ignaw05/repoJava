package prototype.shallow_deep;

public class Persona implements Cloneable {
    String nombre;
    Direccion direccion;

    public Persona(String nombre, Direccion direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Clonación superficial
    protected Persona cloneShallow() {
        try {
            return (Persona) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Clonación profunda
    protected Persona cloneDeep() {
        try {
            Persona clon = (Persona) super.clone();
            clon.direccion = new Direccion(this.direccion.calle); // se crea un nuevo objeto
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", direccion=" + direccion + "]";
    }
}