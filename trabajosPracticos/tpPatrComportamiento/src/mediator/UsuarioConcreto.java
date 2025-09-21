package mediator;

public class UsuarioConcreto extends Usuario {
    public UsuarioConcreto(ChatMediator mediator, String nombre) {
        super(mediator, nombre);
    }
    public void enviar(String mensaje) { System.out.println(nombre + " envía: " + mensaje); mediator.enviar(mensaje, this);
    }
    public void recibir(String mensaje) { System.out.println(nombre + " recibe: " + mensaje);
    } }
