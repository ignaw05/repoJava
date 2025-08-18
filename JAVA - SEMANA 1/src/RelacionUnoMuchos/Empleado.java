package RelacionUnoMuchos;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private String puesto;
    private Departamento departamento;

    public Empleado(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public void setDepartamento(Departamento departamento) {
        // Si es el mismo no hago nada
        if (this.departamento ==  departamento){
            return;
        }
        // Si es distinto le elimino el anterior
        if (this.departamento != null){
            departamento.eliminarEmpleado(this);
        }
        this.departamento = departamento;

        // Valido si ya esta en el departamento
        if (departamento != null && !departamento.getEmpleados().contains(this)){
            departamento.agregarEmpleado(this);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
