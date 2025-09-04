package decorator;

public abstract class PlanDecorator implements Plan{
    protected Plan plan;

    public PlanDecorator(Plan plan) {
        this.plan = plan;
    }

    @Override
    public String descripcion() {
        return plan.descripcion();
    }

    @Override
    public double costo() {
        return plan.costo();
    }
}
