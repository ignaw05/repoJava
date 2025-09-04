package bridge;

public class Promocion extends TipoNotificacion{
    public Promocion(CanalEnvio canalEnvio, String content) {
        super(canalEnvio,content);
    }

    @Override
    public void enviarNotificacion() {
        System.out.println("Enviando PROMOCION '"+ content + "' "+ canalEnvio.enviar());
    }
}

