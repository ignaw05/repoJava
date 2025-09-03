package creacionales.prototype.shallow_deep;

public class Main {
    public static void main(String[] args) {
        Direccion dir = new Direccion("Av. Siempre Viva");
        Persona p1 = new Persona("Juan", dir);

        // Clonación superficial
        Persona pShallow = p1.cloneShallow();
        pShallow.nombre = "Carlos";
        pShallow.direccion.calle = "Calle Falsa"; // afecta a p1 también

        System.out.println("=== Clonación superficial ===");
        System.out.println("Original: " + p1);
        System.out.println("Clon: " + pShallow);

        // Clonación profunda
        Persona pDeep = p1.cloneDeep();
        pDeep.nombre = "Ana";
        pDeep.direccion.calle = "Calle Independencia"; // no afecta a p1

        System.out.println("\n=== Clonación profunda ===");
        System.out.println("Original: " + p1);
        System.out.println("Clon: " + pDeep);
    }
}