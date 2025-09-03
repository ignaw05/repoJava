package interfazGenerica;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        Contenedor<Integer> contenedor = new ContenedorSimple<>();
        Contenedor<String> contenedor2 = new ContenedorSimple<>();

        contenedor.agregar(100);
        System.out.println(contenedor.obtener());

        contenedor2.agregar("cien");
        System.out.println(contenedor2.obtener());
    }
}
