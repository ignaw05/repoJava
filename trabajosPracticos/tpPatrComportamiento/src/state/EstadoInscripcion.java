package state;

public interface EstadoInscripcion {
    void cambiarEstado(Inscripcion inscripcion);
    void aprobar(Inscripcion inscripcion);
    void rechazar(Inscripcion inscripcion);
}
