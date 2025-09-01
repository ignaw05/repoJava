package abstractfactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdminUI implements InterfazUI{
    private String tema;

    @Override
    public void mostrar() {
        System.out.println("Mostrando Interfaz de ADMIN con tema: "+tema);
    }
}
