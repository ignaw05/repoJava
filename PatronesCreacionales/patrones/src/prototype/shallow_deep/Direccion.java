package prototype.shallow_deep;

public class Direccion {
    String calle;

    public Direccion(String calle) {
        this.calle = calle;
    }

    @Override
    public String toString() {
        return "Direccion [calle=" + calle + "]";
    }
}
