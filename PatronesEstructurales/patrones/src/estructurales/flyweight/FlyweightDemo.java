package estructurales.flyweight;

public class FlyweightDemo {
    public static void main(String[] args) {
        FabricaDeLetras fabrica = new FabricaDeLetras();

        String texto = "hola hola";

        int x = 0;
        for (char c : texto.toCharArray()) {
            Letra letra = fabrica.obtenerLetra(c);
            letra.dibujar(x, 10); // Estado extrínseco: posición
            x += 10;
        }
    }
}
