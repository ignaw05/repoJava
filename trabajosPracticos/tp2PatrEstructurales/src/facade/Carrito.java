package facade;

public class Carrito {
    public void agregarAlCarrito(Producto producto){
        System.out.println(producto.getNombre() + " agregado al carrito");
    }
}
