package creacionales.factorymethod;

public class Main {
    public static void main(String[] args) {
        Logistica logistica1 = new LogisticaTerrestre();
        logistica1.planificarEntrega();

        Logistica logistica2 = new LogisticaMaritima();
        logistica2.planificarEntrega();
    }
}
