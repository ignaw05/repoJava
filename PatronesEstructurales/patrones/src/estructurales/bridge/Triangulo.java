package estructurales.bridge;

public class Triangulo extends Forma{
    public Triangulo(Color color) {
        super(color);
    }

    @Override
    void dibujar() {
        System.out.println("Dibujando un triangulo de color " + color.aplicarColor());
    }
}

