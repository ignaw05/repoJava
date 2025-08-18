import hashCode_equals.Sujeto;
import herencia.Animal;
import herencia.Perro;

// Ejemplo de uso
public class Main {
    public static void main(String[] args) {
        // toString()
        Persona persona = new Persona("igna",20);
        System.out.println(persona);

        // HERENCIA
        Animal animal = new Animal("Perro");
        Perro perro = new Perro("Fido", "Labrador");

        System.out.println(animal); // Imprime: herencia.Animal[nombre=Perro]
        System.out.println(perro);  // Imprime: herencia.Animal[nombre=Fido], herencia.Perro[raza=Labrador]

        // hashSet
        Sujeto suj1 = new Sujeto("igna", 30);
        Sujeto suj2 = new Sujeto("igna", 30);

        // sin el override tienen 2 hash distintos, con override
        // tienen el mismo por ser logicamente iguales
        System.out.println(suj1.hashCode());
        System.out.println(suj2.hashCode());


    }
}