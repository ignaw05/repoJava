package abstractfactory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private InterfazUI interfaz;
    private MetodoEnvio metodoEnvio;

    public void iniciarSesion(){
        interfaz.mostrar();
        metodoEnvio.enviar();
    }
}
