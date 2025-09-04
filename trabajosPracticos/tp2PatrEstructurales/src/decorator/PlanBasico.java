package decorator;

public class PlanBasico implements Plan{
    @Override
    public String descripcion() {
        return "Plan básico";
    }

    @Override
    public double costo() {
        return 1000;
    }
}
