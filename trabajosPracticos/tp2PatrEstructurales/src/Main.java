import adapter.*;
import bridge.*;
import decorator.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- ADAPTER ---");
        ImpresoraPDF impresora = new ImpresoraPDF();

        impresora.imprimir("pdf","my_file.pdf");
        impresora.imprimir("txt","mi_archivo.txt");
        impresora.imprimir("docx","mi_tp2.docx");
        impresora.imprimir("mp4","mi_tp2.mp4");

        System.out.println("\n--- BRIDGE ---");
        CanalEnvio email = new Email();
        CanalEnvio sms = new SMS();
        TipoNotificacion alertaMail = new Alerta(email, "Detectamos un inicio de sesion");
        TipoNotificacion recordatorioSMS = new Recordatorio(sms, "Turno medico 18hs");
        TipoNotificacion promocionMail = new Promocion(email, "Cashback del 2% en tus compras");

        alertaMail.enviarNotificacion();
        recordatorioSMS.enviarNotificacion();
        promocionMail.enviarNotificacion();

        System.out.println("\n--- DECORATOR ---");
        System.out.println("Suscripcion 1");
        Plan plan1 = new PlanBasico();
        System.out.println(plan1.descripcion() +" - "+ plan1.costo());
        plan1 = new HD(plan1);
        System.out.println(plan1.descripcion() +" - "+ plan1.costo());
        plan1 = new DescargasOffline(plan1);
        System.out.println(plan1.descripcion() +" - "+ plan1.costo());

        System.out.println("\nSuscripcion 2");
        Plan plan2 = new PlanBasico();
        plan2 = new UltraHD(plan2);
        plan2 = new DescargasOffline(plan2);
        System.out.println(plan2.descripcion() +" - "+ plan2.costo());




    }
}