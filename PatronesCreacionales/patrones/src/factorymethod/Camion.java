package factorymethod;

class Camion implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega por carretera en camión");
    }
}
