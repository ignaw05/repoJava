package Bidireccional_1a1;

public class Patente {
    private String numero;
    private Coche coche;

    public Patente(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
        if (coche != null && coche.getPatente() != this) {
            coche.setPatente(this);
        }
    }
}
