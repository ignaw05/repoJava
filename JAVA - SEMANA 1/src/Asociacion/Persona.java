package Asociacion;

public class Persona {
    private String nombre;
    private Pasaporte pasaporte;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pasaporte getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(Pasaporte pasaporte) {
        if (pasaporte != null){
            this.pasaporte = pasaporte;
        }
    }
}
