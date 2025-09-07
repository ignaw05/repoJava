package composite;

public class Plato implements ElementoMenu{
    private String nombre;
    private double precio;

    public Plato(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public void mostrar() {
        System.out.println(nombre+": $"+precio);
    }
}
