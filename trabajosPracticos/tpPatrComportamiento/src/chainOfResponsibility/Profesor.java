package chainOfResponsibility;

public class Profesor extends Handler{
    protected boolean procesar(Solicitud solicitud){
        if (solicitud.getNivel() <= 2) {
            System.out.println("Profesor resolviendo "+solicitud.getProblema());
            return true;
        }
        return false;
    }
}
