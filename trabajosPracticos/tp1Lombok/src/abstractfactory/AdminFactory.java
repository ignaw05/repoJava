package abstractfactory;

public class AdminFactory implements AbstractFactory{
    public InterfazUI crearInterfaz() {
        return new AdminUI("Oscuro");
    }
    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioExpress();
    }
}
