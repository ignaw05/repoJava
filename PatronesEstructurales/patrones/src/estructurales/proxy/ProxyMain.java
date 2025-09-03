package estructurales.proxy;

public class ProxyMain {
    public static void main(String[] args) {
        Imagen img1 = new ImagenProxy("foto1.jpg");
        Imagen img2 = new ImagenProxy("foto2.jpg");

        // todavía no se cargaron
        System.out.println("Las imágenes aún no están cargadas");
        // ahora se carga y muestra al usarla
        img1.mostrar();
        // esta ya se carga solo cuando se usa
        img2.mostrar();
    }
}