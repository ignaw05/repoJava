package abstractfactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioUI implements  InterfazUI{
    private String tema;
    public void mostrar() {
        System.out.println("Mostrando Interfaz de un usuario normal con tema: "+tema);
    }
}
