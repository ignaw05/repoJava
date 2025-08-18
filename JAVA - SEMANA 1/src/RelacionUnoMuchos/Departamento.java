package RelacionUnoMuchos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Departamento {
    private String nombre;
    private List<Empleado> empleados = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void eliminarEmpleado(Empleado emp){
        // Verifico que este en mis empleados
        if (emp != null && empleados.contains(emp)){
            empleados.remove(emp);
        }
        // Como lo elimine, le tengo que sacar el departamento
        if (emp.getDepartamento() == this){
            emp.setDepartamento(null);
        }

    }

    public void agregarEmpleado(Empleado emp){
        // Evitar duplicados
        if (emp != null && !this.empleados.contains(emp)) {
            empleados.add(emp);
        }
        // Como lo agregue, ahora tengo que ponerle que pertenece a este departamento
        if (emp.getDepartamento() != this){
            emp.setDepartamento(this);
        }
    }

    public List<Empleado> getEmpleados() {
        // Para devolver una copia
        return Collections.unmodifiableList(empleados);
    }

}
