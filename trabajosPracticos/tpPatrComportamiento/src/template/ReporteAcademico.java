package template;

public abstract class ReporteAcademico {
    public final void generarReporte(){
        setEncabezado();
        setContendio();
        setPie();
    }

    protected void setEncabezado(){
    }
    protected void setContendio(){
        System.out.println("Este reporte habla sobre el desempeño en el curso");
    }
    protected void setPie(){}
}
