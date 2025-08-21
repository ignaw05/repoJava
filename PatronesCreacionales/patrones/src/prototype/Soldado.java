package prototype;

public class Soldado implements Cloneable {
    private String nombre;
    private String arma;
    private int vida;
    private String uniforme;
    private String nivel;

    public Soldado(String nombre, String arma, int vida, String nivel, String uniforme) {
        this.nombre = nombre;
        this.arma = arma;
        this.vida = vida;
        this.nivel = nivel;
        this.uniforme = uniforme;
    }

    @Override
    protected Soldado clone() {
        try {
            return (Soldado) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setUniforme(String uniforme) { this.uniforme = uniforme; }

    public void setArma(String arma) {
        this.arma = arma;
    }

    @Override
    public String toString() {
        return "Soldado [nombre=" + nombre + ", arma=" + arma + ", vida=" + vida + ", nivel= "+ nivel+ ", uniforme=" + uniforme + "]";
    }
}