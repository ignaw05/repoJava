package entities;

import iterator.CursoIterator;
import iterator.CursosAlumnoIterator;
import mediator.ChatMediator;
import mediator.Usuario;

public class Alumno {
    private java.util.List<Curso> cursos = new java.util.ArrayList<>();
    private String nombre;
    private Usuario usuario;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }

    public CursoIterator iterator(){
        return new CursosAlumnoIterator(cursos);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //    @Override
//    public void enviar(String mensaje) {
//        System.out.println(nombre + " envia: "+mensaje);
//        mediator.enviar(mensaje,this);
//    }
//
//    @Override
//    public void recibir(String mensaje) {
//        System.out.println(nombre+ " recibe: "+mensaje);
//    }
}
