package ej;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtener la clase
            Class<?> clazz = Class.forName("ej.Persona");
            // Obtener los métodos de la clase
            Method comerMethod = clazz.getDeclaredMethod("comer");
            Method saludarMethod = clazz.getDeclaredMethod("saludar");
            comerMethod.setAccessible(true);
            saludarMethod.setAccessible(true);

            // faltan los declaredMethods
            Method[] methods = clazz.getMethods();
            System.out.println("\nMétodos:");
            for (Method method : methods) {
                System.out.println(" " + method.getName());
            }

            // Obtener los campos de la clase
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("\nCampos:");
            for (Field field : fields) {
                System.out.println(" " + field.getName());
            }

            Constructor[] constructors = clazz.getConstructors();
            System.out.println("\nConstructores:");
            for (Constructor constructor : constructors) {
                System.out.println(" " + constructor.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
