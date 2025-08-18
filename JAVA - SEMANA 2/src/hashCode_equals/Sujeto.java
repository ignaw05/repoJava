package hashCode_equals;

import java.util.Objects;

public class Sujeto {
    private String name;
    private Integer edad;

    // equals == true si apuntan a la misma direccion de memoria
    // (this == obj)

    public Sujeto(String name, Integer edad) {
        this.name = name;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Si son el mismo objeto en memoria, son iguales.
        if (this == obj) return true;

        // 2. Si el objeto es null o de una clase diferente, no son iguales.
        if (obj == null || getClass() != obj.getClass()) return false;

        // 3. Castear el objeto para comparar sus propiedades.
        Sujeto otra = (Sujeto) obj;

        // 4. Comparar las propiedades relevantes para la igualdad lógica.
        return Objects.equals(edad, otra.edad) && Objects.equals(name, otra.name);
    }

    // Si x.equals(y) devuelve true, entonces x.hashCode() debe ser
    // igual a y.hashCode()
    @Override
    public int hashCode() {
        // Utiliza Objects.hash() para generar un hashCode seguro y legible.
        return Objects.hash(name, edad);
    }

    // Al hacer estos override, lo que hacemos es a los objetos logicamente
    // iguales, asignarles el mismo hashCode
}

