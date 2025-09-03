package estructurales.decorator;

public class ConLeche extends CafeDecorador {
    public ConLeche(Cafe cafe) {
            super(cafe);
    }

    @Override
    public String descripcion() {
        return cafe.descripcion() + " + Leche";
    }

    @Override
    public double costo() {
        return cafe.costo() + 5.0;
    }
}
