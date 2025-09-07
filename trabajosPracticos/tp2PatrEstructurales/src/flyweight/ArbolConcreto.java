package flyweight;

public class ArbolConcreto implements Arbol{
    private final String tipo;
    private final String textura;
    private final String color;

    public ArbolConcreto(String tipo, String textura, String color) {
        this.tipo = tipo;
        this.textura = textura;
        this.color = color;
        System.out.println("Creando objeto para: "+tipo);
    }

    @Override
    public void mostrar(int x, int y) {
        System.out.println("El "+tipo+", "+textura+" de color "+color+" esta en ( "+x+", "+y+" )");
    }
}
