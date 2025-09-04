package decorator;

public class HD extends PlanDecorator{

    public HD(Plan plan) {
        super(plan);
    }

    @Override
    public String descripcion() {
        return plan.descripcion() + " + HD";
    }

    @Override
    public double costo() {
        return plan.costo() + 500;
    }
}
