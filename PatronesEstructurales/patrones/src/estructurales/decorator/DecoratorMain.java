package estructurales.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        Cafe cafe = new CafeSimple();
        System.out.println(cafe.descripcion() + " cuesta $" + cafe.costo());

        cafe = new ConLeche(cafe);  // agrego leche
        System.out.println(cafe.descripcion() + " cuesta $" + cafe.costo());

        cafe = new ConAzucar(cafe); // agrego azúcar
        System.out.println(cafe.descripcion() + " cuesta $" + cafe.costo());
    }
}
