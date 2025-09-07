package composite;

import java.util.ArrayList;
import java.util.List;

public class Menu implements ElementoMenu{
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    public void agregarElemento (ElementoMenu elemento){
        elementos.add(elemento);
    }

    @Override
    public void mostrar() {
        System.out.println("Menu - "+nombre);
        for (ElementoMenu item : elementos){
            item.mostrar();
        }
    }
}
