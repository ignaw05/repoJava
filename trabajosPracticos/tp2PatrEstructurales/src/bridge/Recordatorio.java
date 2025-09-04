package bridge;

public class Recordatorio extends TipoNotificacion{
    public Recordatorio(CanalEnvio canalEnvio, String content) {
        super(canalEnvio,content);
    }

    @Override
    public void enviarNotificacion() {
        System.out.println("Enviando RECORDATORIO '"+ content + "' "+ canalEnvio.enviar());
    }
}

