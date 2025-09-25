package template;

import entities.Curso;

public class ReporteCurso extends ReporteAcademico{
    private Curso curso;

    public ReporteCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    protected void setEncabezado() {
        System.out.println("Reporte del curso: "+curso.getNombre());
    }

    @Override
    protected void setPie() {
        System.out.println("En promedio el curso estuvo regular");
    }
}
