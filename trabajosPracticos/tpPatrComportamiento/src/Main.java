import chainOfResponsibility.*;
import command.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- CHAIN OF RESPONSIBILITY ---");
        Handler asistente = new Asistente();
        Handler profesor = new Profesor();
        Handler coordinador = new Coordinador();

        Solicitud solicitud1 = new Solicitud("Problema de internet",1);
        Solicitud solicitud2 = new Solicitud("Fallo en la compilacion",2);
        Solicitud solicitud3 = new Solicitud("Base de datos corrupta",3);

        asistente.setNext(profesor);
        profesor.setNext(coordinador);

        asistente.handle(solicitud1);
        asistente.handle(solicitud2);
        asistente.handle(solicitud3);

        System.out.println("\n--- COMMAND ---");
        Curso curso = new Curso("Desarrollo de Software");
        Command inscribir = new InscribirseCursoCommand(curso);
        Command abandonar = new AbandonarCursoCommand(curso);
        Command certificado = new SolicitarCertificadoCommand(curso);

        GestionCursoInvoker gestionCurso = new GestionCursoInvoker();
        gestionCurso.setCommand(inscribir);
        gestionCurso.ejecutar();

        gestionCurso.setCommand(abandonar);
        gestionCurso.ejecutar();

        gestionCurso.setCommand(certificado);
        gestionCurso.ejecutar();
    }
}