package decorator;

public class DescargasOffline extends PlanDecorator{

    public DescargasOffline(Plan plan) {
        super(plan);
    }

    @Override
    public String descripcion() {
        return plan.descripcion() + " + Descargas Offline";
    }

    @Override
    public double costo() {
        return plan.costo() + 700;
    }
}
