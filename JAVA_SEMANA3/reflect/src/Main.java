import java.lang.reflect.*;

import reflect1.Person;
public class Main {
    public static void main(String[] args) {
        try {
            // Crear una instancia de reflect1.Person
            Person person = new Person("John",18);

            // Obtener la clase de la instancia
            Class<?> clazz = person.getClass();
            System.out.println(clazz);

            // Acceder y modificar el campo privado 'name'
            Field nameField = clazz.getDeclaredField("name"); // toma un atributo (+- getElementById)
            Field ageField = clazz.getDeclaredField("age");
            nameField.setAccessible(true); // hace que name pueda ser publica
            ageField.setAccessible(true);
            nameField.set(person, "Colo");
            ageField.set(person, 10);

            // Invocar el metodo privado hello
            Method sayHelloMethod = clazz.getDeclaredMethod("sayHello");
            sayHelloMethod.setAccessible(true);
            sayHelloMethod.invoke(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}