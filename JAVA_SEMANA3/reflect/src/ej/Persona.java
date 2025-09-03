package ej;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void saludar(){
        System.out.println("Hola soy "+nombre+" "+apellido);
    }
    private void comer(){System.out.println("Comemos con la boca");
    }
}
