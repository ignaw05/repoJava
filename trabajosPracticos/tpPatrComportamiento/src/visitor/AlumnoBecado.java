package visitor;

public class AlumnoBecado implements AlumnoTipo{
    private Double costo_cuota;

    public AlumnoBecado(Double costo_cuota) {
        this.costo_cuota = costo_cuota;
    }

    @Override
    public void aceptar(Visitor visitor) {
        visitor.visitar(this);
    }

    public Double getCosto_cuota() {
        return costo_cuota;
    }

    public void setCosto_cuota(Double costo_cuota) {
        this.costo_cuota = costo_cuota;
    }
}
