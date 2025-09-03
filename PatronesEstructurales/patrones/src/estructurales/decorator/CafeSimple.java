package estructurales.decorator;

public class CafeSimple implements Cafe {
    @Override
    public String descripcion() {
        return "Café simple";
    }

    @Override
    public double costo() {
        return 20.0;
    }
}
