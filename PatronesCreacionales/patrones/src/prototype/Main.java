package prototype;

public class Main {
    public static void main(String[] args) {
        // Soldado prototipo
        Soldado soldadoBase = new Soldado("Base", "Rifle", 100, "heroico","Infanteria");

        // Clonamos para crear nuevos soldados
        Soldado soldado1 = soldadoBase.clone();
        Soldado soldado2 = soldadoBase.clone();

        // Personalizamos algunos atributos
        soldado1.setNombre("Colo");
        soldado1.setArma("Scar");
        soldado2.setNombre("Ale");
        soldado1.setUniforme("Colorado");
        soldado2.setUniforme("Marino");
        soldado2.setArma("Groza");

        System.out.println(soldadoBase);
        System.out.println(soldado1);
        System.out.println(soldado2);
    }
}
