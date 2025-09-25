package template;

import entities.Alumno;
import entities.Curso;

public class ReporteAlumno extends ReporteAcademico{
    private Alumno alumno;
    private Curso curso;

    public ReporteAlumno(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
    }

    @Override
    protected void setPie() {
        System.out.println("Su desempeño fue excelente");
        alumno.verPromedio();
    }

    @Override
    protected void setEncabezado() {
        System.out.println("Reporte de "+alumno.getNombre()+" del curso: "+curso.getNombre());
    }
}
