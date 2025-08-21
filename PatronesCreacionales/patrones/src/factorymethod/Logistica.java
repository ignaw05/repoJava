package factorymethod;

// Creador
abstract class Logistica {
    // Factory Method
    public abstract Transporte crearTransporte();

    public void planificarEntrega() {
        Transporte transporte = crearTransporte();
        transporte.entregar();
    }
}