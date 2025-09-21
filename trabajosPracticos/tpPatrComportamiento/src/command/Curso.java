package command;

public class Curso {
    private String nombre;

    public Curso(String nombre) {
        this.nombre = nombre;
    }

    public void inscribir() {
        System.out.println("Inscribiendo en "+nombre);
    }
    public void abandonar() {
        System.out.println("Abandonando "+nombre);
    }
    public void certificado() {
        System.out.println("Solicitando certificado de "+nombre);
    }
}
