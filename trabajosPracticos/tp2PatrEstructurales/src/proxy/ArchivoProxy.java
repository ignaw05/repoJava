package proxy;

public class ArchivoProxy implements Archivo{
    private ArchivoReal archivo;

    public ArchivoProxy(ArchivoReal archivo) {
        this.archivo = archivo;
    }

    @Override
    public void abrir(Usuario... args) {
        Usuario usuario = args[0];
        try{
            if (usuario.isAccesoAdmin()){
                archivo.abrir();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(usuario.getNombreUsuario()+" no tiene acceso a este archivo");
        }

    }
}
