package creacionales.factorymethod;

class Barco implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega por mar en barco");
    }
}