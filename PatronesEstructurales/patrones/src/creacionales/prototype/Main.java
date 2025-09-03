package creacionales.prototype;

public class Main {
    public static void main(String[] args) {
        // Soldado prototipo
        Soldado soldadoBase = new Soldado("Base", "Rifle", 100, "Infanteria");

        // Clonamos para crear nuevos soldados
        Soldado soldado1 = soldadoBase.clone();
        Soldado soldado2 = soldadoBase.clone();

        // Personalizamos algunos atributos
        soldado1.setNombre("Alpha");
        soldado2.setNombre("Bravo");
        soldado2.setUniforme("Marino");

        System.out.println(soldadoBase);
        System.out.println(soldado1);
        System.out.println(soldado2);
    }
}
