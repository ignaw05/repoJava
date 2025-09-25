package visitor;

import entities.Alumno;

public interface Visitor {
    void visitar(AlumnoRegular alumnoRegular);
    void visitar(AlumnoBecado alumnoBecado);
}
