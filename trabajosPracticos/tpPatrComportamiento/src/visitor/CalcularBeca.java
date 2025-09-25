package visitor;

public class CalcularBeca implements Visitor{
    @Override
    public void visitar(AlumnoRegular alumnoRegular) {
        alumnoRegular.setCosto_cuota(alumnoRegular.getCosto_cuota()*0.8);
        System.out.println("Descuento del 20% aplicado, cuota: $"+alumnoRegular.getCosto_cuota());
    }

    @Override
    public void visitar(AlumnoBecado alumnoBecado) {
        alumnoBecado.setCosto_cuota(alumnoBecado.getCosto_cuota()*0.5);
        System.out.println("Beca del 50% aplicada, cuota: $"+alumnoBecado.getCosto_cuota());
    }
}
