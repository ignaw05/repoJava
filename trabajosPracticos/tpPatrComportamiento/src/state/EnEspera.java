package state;

public class EnEspera implements EstadoInscripcion{
    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        inscripcion.setEstado(this);
        System.out.println("Inscripcion en espera");
    }

    @Override
    public void aprobar(Inscripcion inscripcion) {
        inscripcion.setEstado(new Inscripto());
        System.out.println(inscripcion.getAlumno().getNombre()+" inscripto en "+inscripcion.getCurso().getNombre());
    }

    @Override
    public void rechazar(Inscripcion inscripcion) {
        inscripcion.setEstado(new Cancelado());
        System.out.println(inscripcion.getAlumno().getNombre()+" fue cancelado en "+inscripcion.getCurso().getNombre());
    }
}
