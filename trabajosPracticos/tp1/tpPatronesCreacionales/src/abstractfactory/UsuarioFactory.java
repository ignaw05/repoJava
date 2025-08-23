package main.java.abstractfactory;

public class UsuarioFactory implements AbstractFactory{

    public MetodoEnvio crearMetodoEnvio() {
        return new EnvioNormal();
    }
    public InterfazUI crearInterfaz() {
        return new UsuarioUI();
    }
}
