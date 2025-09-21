package state;

public class Inscripto implements EstadoInscripcion{
    @Override
    public void cambiarEstado(Inscripcion inscripcion) {
        System.out.println("Inscripto");
        inscripcion.setEstado(this);
    }

    @Override
    public void aprobar(Inscripcion inscripcion) {
        System.out.println(inscripcion.getAlumno().getNombre()+" ya esta inscripto en "+inscripcion.getCurso().getNombre());
    }

    @Override
    public void rechazar(Inscripcion inscripcion) {
        inscripcion.setEstado(new Cancelado());
        System.out.println(inscripcion.getAlumno().getNombre()+" fue cancelado en "+inscripcion.getCurso().getNombre());
    }
}
