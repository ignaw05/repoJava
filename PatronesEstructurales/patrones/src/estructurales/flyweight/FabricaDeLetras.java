package estructurales.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FabricaDeLetras {
    private Map<Character, Letra> letras = new HashMap<>();

    public Letra obtenerLetra(char c) {
        Letra letra = letras.get(c);
        if (letra == null) {
            letra = new LetraConcreta(c);
            letras.put(c, letra);
        }
        return letra;
    }
}
