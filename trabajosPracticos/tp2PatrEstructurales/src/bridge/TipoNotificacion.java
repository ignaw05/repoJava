package bridge;

public abstract class TipoNotificacion {
    protected CanalEnvio canalEnvio;
    protected String content;

    public TipoNotificacion(CanalEnvio canalEnvio, String content) {
        this.canalEnvio = canalEnvio;
        this.content = content;
    }

     public abstract void enviarNotificacion();
}
