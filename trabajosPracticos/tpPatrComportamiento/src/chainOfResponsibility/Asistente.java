package chainOfResponsibility;

public class Asistente extends Handler{
    protected boolean procesar(Solicitud solicitud){
        if (solicitud.getNivel() <= 1) {
            System.out.println("Asistente resolviendo "+solicitud.getProblema());
            return true;
        }
        return false;
    }
}
