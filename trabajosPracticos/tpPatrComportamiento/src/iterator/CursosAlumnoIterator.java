package iterator;

import entities.Curso;

import java.util.List;

public class CursosAlumnoIterator implements CursoIterator{
    private java.util.List<Curso> cursos;
    private int posicion = 0;

    public CursosAlumnoIterator(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public boolean hasNext() {
        return posicion < cursos.size();
    }

    @Override
    public Curso next() {
        return cursos.get(posicion++);
    }
}
