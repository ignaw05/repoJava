package estructurales.proxy;

public class ImagenProxy implements Imagen {
    private String archivo;
    private ImagenReal imagenReal;

    public ImagenProxy(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void mostrar() {
        if (imagenReal == null) {
            imagenReal = new ImagenReal(archivo); // se carga solo la primera vez
        }
        imagenReal.mostrar();
    }
}
