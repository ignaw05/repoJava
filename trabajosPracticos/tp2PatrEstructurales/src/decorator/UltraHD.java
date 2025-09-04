package decorator;

public class UltraHD extends PlanDecorator{

    public UltraHD(Plan plan) {
        super(plan);
    }

    @Override
    public String descripcion() {
        return plan.descripcion() + " + UltraHD";
    }

    @Override
    public double costo() {
        return plan.costo() + 1000;
    }
}

