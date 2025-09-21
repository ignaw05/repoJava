import chainOfResponsibility.*;
import command.*;
import entities.Alumno;
import entities.Curso;
import iterator.CursoIterator;

public class Main {
    public static void main(String[] args) {
//        ENTITIES
        System.out.println("--- ENTITIES ---");
        Curso curso1 = new Curso("Desarrollo de Software");
        Curso curso2 = new Curso("Diseño de sistemas");
        Curso curso3 = new Curso("Redes neuronales");

        Alumno alumno1 = new Alumno("Igna");
        Alumno alumno2 = new Alumno("Ale");
        Alumno alumno3 = new Alumno("Lucia");

//        CHAIN OF RESPONSIBILITY
        System.out.println("\n--- CHAIN OF RESPONSIBILITY ---");
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

//      COMMAND
        System.out.println("\n--- COMMAND ---");
        Command inscribir = new InscribirseCursoCommand(curso1);
        Command abandonar = new AbandonarCursoCommand(curso1);
        Command certificado = new SolicitarCertificadoCommand(curso1);

        GestionCursoInvoker gestionCurso = new GestionCursoInvoker();
        gestionCurso.setCommand(inscribir);
        gestionCurso.ejecutar();

        gestionCurso.setCommand(abandonar);
        gestionCurso.ejecutar();

        gestionCurso.setCommand(certificado);
        gestionCurso.ejecutar();

//        ITERATOR
        System.out.println("\n--- ITERATOR ---");
        alumno1.agregarCurso(curso1);
        alumno1.agregarCurso(curso2);
        alumno1.agregarCurso(curso3);

        CursoIterator iterador = alumno1.iterator();
        while (iterador.hasNext()){
            System.out.println(iterador.next().getNombre());
        }
    }
}