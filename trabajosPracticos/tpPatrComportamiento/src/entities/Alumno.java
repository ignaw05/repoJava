package entities;

import iterator.CursoIterator;
import iterator.CursosAlumnoIterator;
import mediator.ChatMediator;
import mediator.Usuario;
import observer.Observer;

public class Alumno implements Observer {
    private java.util.List<Curso> cursos = new java.util.ArrayList<>();
    private String nombre;
    private Usuario usuario;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }

    public String getNombre() {
        return nombre;
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

    @Override
    public void update(String msg, Curso curso) {
        System.out.println(nombre+ " tiene un nuevo horario para "+curso.getNombre()+": "+msg);
    }
}
