package facade;

public class Pago {
    public void pagar(Producto producto){
        System.out.println("Pagando "+ producto.getNombre()+". Total: $"+producto.getPrecio());
        System.out.println("Pago aceptado!");
    }
}
