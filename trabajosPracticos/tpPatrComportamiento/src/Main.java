import chainOfResponsibility.*;
import command.*;
import entities.Alumno;
import entities.Curso;
import entities.Profesor;
import iterator.CursoIterator;
import mediator.ChatMediator;
import mediator.ChatRoom;
import mediator.Usuario;
import mediator.UsuarioConcreto;
import memento.Examen;
import memento.Historial;

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

        Profesor profesor1 = new Profesor("Gerardo Magni",curso1);

//        CHAIN OF RESPONSIBILITY
        System.out.println("\n--- CHAIN OF RESPONSIBILITY ---");
        Handler asistente = new Asistente();
        Handler profesor = profesor1;
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

//        MEDIATOR
        System.out.println("\n--- MEDIATOR ---");
        ChatMediator chat3k10 = new ChatRoom();
        Usuario user1 = new UsuarioConcreto(chat3k10,"ignaw05");
        Usuario user2 = new UsuarioConcreto(chat3k10,"gmagni");
        Usuario user3 = new UsuarioConcreto(chat3k10,"alealbornoz");
        alumno1.setUsuario(user1);
        alumno2.setUsuario(user3);
        profesor1.setUsuario(user2);

        chat3k10.agregarUsuario(alumno1.getUsuario());
        chat3k10.agregarUsuario(profesor1.getUsuario());
        chat3k10.agregarUsuario(alumno2.getUsuario());

        alumno1.getUsuario().enviar("Hola profe tengo una duda con este TP");
        profesor1.getUsuario().enviar("Lo vemos en clase el miercoles");

//        MEMENTO
        System.out.println("\n--- MEMENTO ---");
        Examen examen = new Examen(curso1,"Que es JAVA?");
        Historial historial = new Historial();

        examen.agregarRespuesta("JAVA es un lenguaje");
        historial.guardar(examen.save());
        examen.agregarRespuesta(" de programacion");
        historial.guardar(examen.save());
        examen.agregarRespuesta(" orientada a objetos");
        historial.guardar(examen.save());
        System.out.println("Preguntas: "+examen.getPreguntas());
        System.out.println("Respuestas: "+examen.getRespuestas());

        examen.restore(historial.deshacer());
        System.out.println("Restore 1: "+examen.getRespuestas());
        examen.restore(historial.deshacer());
        System.out.println("Restore 2: "+examen.getRespuestas());
        examen.restore(historial.deshacer());
        System.out.println("Restore 3: "+examen.getRespuestas());
    }
}