import adapter.*;
import bridge.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- ADAPTER ---");
        ImpresoraPDF impresora = new ImpresoraPDF();

        impresora.imprimir("pdf","my_file.pdf");
        impresora.imprimir("txt","mi_archivo.txt");
        impresora.imprimir("docx","mi_tp2.docx");
        impresora.imprimir("mp4","mi_tp2.mp4");

        System.out.println("--- BRIDGE ---");
        CanalEnvio email = new Email();
        CanalEnvio sms = new SMS();
        TipoNotificacion alertaMail = new Alerta(email, "Detectamos un inicio de sesion");
        TipoNotificacion recordatorioSMS = new Recordatorio(sms, "Turno medico 18hs");
        TipoNotificacion promocionMail = new Promocion(email, "Cashback del 2% en tus compras");

        alertaMail.enviarNotificacion();
        recordatorioSMS.enviarNotificacion();
        promocionMail.enviarNotificacion();
    }
}