package estructurales.flyweight;

public class LetraConcreta implements Letra {
    private final char simbolo; // Estado intrínseco: la forma de la letra

    public LetraConcreta(char simbolo) {
        this.simbolo = simbolo;
        System.out.println("Creando objeto para la letra: " + simbolo);
    }

    @Override
    public void dibujar(int x, int y) {
        System.out.println("Dibujando letra '" + simbolo + "' en posición (" + x + "," + y + ")");
    }
}
