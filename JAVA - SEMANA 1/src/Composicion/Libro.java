package Composicion;

public class Libro {
    private String titulo;
    private Portada portada;

    public Libro(String titulo, String ilustracion) {
        this.titulo = titulo;
        this.portada = new Portada(ilustracion);
    }

    public void mostrarLibro(){
        if (titulo != null && portada != null){
            System.out.println("Titulo: "+titulo+"\nPortada: "+portada);
        } else {
            System.out.println("Te falta data cumpa");
        }
    }
}
