package state;

import entities.Alumno;
import entities.Curso;

public class Inscripcion{
    private EstadoInscripcion estado;
    private Curso curso;
    private Alumno alumno;

    public Inscripcion(Curso curso, Alumno alumno) {
        this.estado = new EnEspera();
        this.curso = curso;
        this.alumno = alumno;
    }

    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }

    public void aceptar() {estado.aprobar(this);}
    public void rechazar() {estado.rechazar(this);}

    public Curso getCurso() {
        return curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }
}
