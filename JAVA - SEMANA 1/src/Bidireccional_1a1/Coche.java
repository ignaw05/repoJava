package Bidireccional_1a1;

public class Coche {
    private String modelo;
    private Patente patente;

    public Coche(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Patente getPatente() {
        return patente;
    }

    public void setPatente(Patente patente) {
        this.patente = patente;
        //IMPORTANTISIMO
        if (patente != null && patente.getCoche() != this) {
            patente.setCoche(this);
        }
    }

    public String getDatos(){
        return modelo+" - "+patente.getNumero();
    }
}
