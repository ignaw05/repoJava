package estructurales.decorator;

abstract class CafeDecorador implements Cafe {
    protected Cafe cafe;

    public CafeDecorador(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public String descripcion() {
        return cafe.descripcion();
    }

    @Override
    public double costo() {
        return cafe.costo();
    }
}
