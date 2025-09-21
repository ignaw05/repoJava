package mediator;

public class ChatRoom implements ChatMediator {
    private java.util.List<Usuario> usuarios = new java.util.ArrayList<>();
    @Override
    public void enviar(String msg, Usuario usuario) {
        for (Usuario u:usuarios){
            if (u != usuario){
                u.recibir(msg);
            }
        }
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
