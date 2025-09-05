package facade;

public class TiendaFacade {
    private Carrito carrito;
    private Pago pago;
    private Envio envio;

    public TiendaFacade(Carrito carrito, Pago pago, Envio envio) {
        this.carrito = carrito;
        this.pago = pago;
        this.envio = envio;
    }

    public void comprar(Producto producto, String direccion){
        carrito.agregarAlCarrito(producto);
        pago.pagar(producto);
        envio.enviarProducto(producto,direccion);
    }
}
