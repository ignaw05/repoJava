package chainOfResponsibility;

public class Solicitud {
    private String problema;
    private int nivel;

    public Solicitud(String problema, int nivel) {
        this.problema = problema;
        this.nivel = nivel;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
