package estructurales.decorator;

public class ConAzucar extends CafeDecorador {
    public ConAzucar(Cafe cafe) {
        super(cafe);
    }

    @Override
    public String descripcion() {
        return cafe.descripcion() + " + Azúcar";
    }

    @Override
    public double costo() {
        return cafe.costo() + 2.0;
    }
}