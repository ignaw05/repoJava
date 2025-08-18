public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sin esta sobreescritura me muestra en un System.out.println(persona);
    // return getClass().getName() + "@" + Integer.toHexString(hashCode());
    @Override
    public String toString() {
        return "Persona[nombre=" + nombre + ", edad=" + edad + "]";
    }
}