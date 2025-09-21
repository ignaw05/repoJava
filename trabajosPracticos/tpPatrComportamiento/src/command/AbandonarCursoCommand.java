package command;

public class AbandonarCursoCommand implements Command{
    private Curso curso;

    public AbandonarCursoCommand(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void execute() {
        curso.abandonar();
    }
}
