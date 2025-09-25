package strategy;

import java.util.List;

public class PromedioSimple implements CalculoNota{
    @Override
    public void calcular(List<Integer> notas) {
        Float promedio = 0F;
        for (Integer nota: notas){
            promedio += nota;
        }
        promedio = promedio / notas.size();
        System.out.println("Promedio simple: "+promedio);
    }
}
