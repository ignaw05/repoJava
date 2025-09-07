package flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaDeArboles {
    private Map<String,Arbol> arboles = new HashMap<>();

    public Arbol obtenerArbol(String tipo, String textura, String color) {
        Arbol arbol = arboles.get(tipo+textura+color);
        if (arbol == null){
            arbol = new ArbolConcreto(tipo,textura,color);
            arboles.put(tipo+textura+color, arbol);
        }
        return arbol;
    }
}
