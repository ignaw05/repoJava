package estructurales.bridge;

public class BridgeDemoMain {
    public static void main(String[] args) {
        Forma circuloRojo = new Circulo(new Rojo());
        Forma cuadradoAzul = new Cuadrado(new Azul());

        circuloRojo.dibujar();
        cuadradoAzul.dibujar();
    }
}
