package bridge;

public class Alerta extends TipoNotificacion{

    public Alerta(CanalEnvio canalEnvio, String content) {
        super(canalEnvio,content);
    }

    @Override
    public void enviarNotificacion() {
        System.out.println("Enviando ALERTA '"+ content + "' "+ canalEnvio.enviar());
    }
}
