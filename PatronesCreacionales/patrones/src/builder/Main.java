package builder;

public class Main {

    //Ejemplo de la vida real: Construcción de un Auto
    public static void main(String[] args) {
        Auto auto1 = new Auto.Builder("Toyota", "Corolla")
                .setColor("Rojo")
                .setAireAcondicionado(true)
                .setGps(true)
                .build();

        Auto auto2 = new Auto.Builder("Ford", "Focus")
                .setColor("Azul")
                .build();

        System.out.println(auto1);
        System.out.println(auto2);
    }
}
