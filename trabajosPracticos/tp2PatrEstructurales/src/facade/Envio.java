package facade;

public class Envio {
    public void enviarProducto(Producto producto, String direccion){
        System.out.println("Envio coordinado. "+ producto.getNombre()+ " llegará en 24 horas a "+direccion);
    }
}
