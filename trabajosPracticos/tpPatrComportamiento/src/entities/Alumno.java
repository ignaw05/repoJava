package entities;

import iterator.CursoIterator;
import iterator.CursosAlumnoIterator;

public class Alumno {
    private java.util.List<Curso> cursos = new java.util.ArrayList<>();
    private String nombre;

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }

    public CursoIterator iterator(){
        return new CursosAlumnoIterator(cursos);
    }

}
