package chainOfResponsibility;

public class Coordinador extends Handler{
    protected boolean procesar(Solicitud solicitud){
        if (solicitud.getNivel() <= 3) {
            System.out.println("Coordinador resolviendo "+solicitud.getProblema());
            return true;
        }
        return false;
    }
}
