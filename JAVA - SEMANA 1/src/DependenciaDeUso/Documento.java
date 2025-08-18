package DependenciaDeUso;

public class Documento {
    private String titulo;

    public Documento(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
