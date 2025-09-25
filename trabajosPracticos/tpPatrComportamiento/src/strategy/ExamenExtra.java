package strategy;

import java.util.List;

public class ExamenExtra implements CalculoNota{
    private Integer examen_extra;

    public ExamenExtra(Integer examen_extra) {
        this.examen_extra = examen_extra;
    }

    @Override
    public void calcular(List<Integer> notas) {
        Float promedio = 0F;
        for (Integer nota:notas){
            promedio += nota;
        }
        promedio = (promedio + examen_extra)/ (notas.size() + 1);
        System.out.println("Promedio con examen extra: "+promedio);
    }
}
