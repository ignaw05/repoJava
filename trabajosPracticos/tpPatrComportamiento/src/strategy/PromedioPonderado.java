package strategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota{
    @Override
    public void calcular(List<Integer> notas) {
        if (notas.size() == 3){
            Float promedio = (float) (notas.get(0)*0.50 + notas.get(1)*0.30 + notas.get(2)*0.20);
            System.out.println("Promedio ponderado: "+promedio);
        } else {
            System.out.println("Ingrese todas las notas (3)");
        }
    }
}
