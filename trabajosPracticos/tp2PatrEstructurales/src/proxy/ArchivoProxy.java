package proxy;

public class ArchivoProxy implements Archivo{
    private ArchivoReal archivo;
    private String nombre;
    private String contenido;

    public ArchivoProxy(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
    }

    @Override
    public void abrir(Usuario... args) {
        Usuario usuario = args[0];
        try{
            if (usuario.isAccesoAdmin()){
                this.archivo = new ArchivoReal(this.nombre,this.contenido);
                archivo.abrir();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(usuario.getNombreUsuario()+" no tiene acceso a este archivo");
        }

    }
}
