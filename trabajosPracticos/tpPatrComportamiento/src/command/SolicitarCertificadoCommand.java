package command;

public class SolicitarCertificadoCommand implements Command{
    private Curso curso;

    public SolicitarCertificadoCommand(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void execute() {
        curso.certificado();
    }
}
