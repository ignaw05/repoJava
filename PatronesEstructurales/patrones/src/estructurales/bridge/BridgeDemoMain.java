package estructurales.bridge;

public class BridgeDemoMain {
    public static void main(String[] args) {
        Color verde = new Verde();

        Forma circuloRojo = new Circulo(new Rojo());
        Forma cuadradoAzul = new Cuadrado(new Azul());
        Forma trianguloRojo = new Triangulo((new Rojo()));
        Forma trianguloVerde = new Triangulo(verde);

        trianguloRojo.dibujar();
        trianguloVerde.dibujar();

        circuloRojo.dibujar();
        cuadradoAzul.dibujar();
    }
}
