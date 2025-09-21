package mediator;

public interface ChatMediator {
    void enviar(String msg, Usuario usuario);
    void agregarUsuario(Usuario usuario);
}
