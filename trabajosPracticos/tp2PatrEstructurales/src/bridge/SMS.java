package bridge;

public class SMS implements CanalEnvio{

    @Override
    public String enviar() {
        return "via SMS";
    }
}
