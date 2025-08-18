package DependenciaDeCreacion;

public class GestorUsuarios {
    public void crearYMostrar(String nombre){
        Usuario user = new Usuario(nombre);
        System.out.println("El nombre de usuario es: "+user.getNombre());
    }
}
