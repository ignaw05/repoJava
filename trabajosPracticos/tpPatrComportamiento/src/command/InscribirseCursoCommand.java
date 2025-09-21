package command;

public class InscribirseCursoCommand implements Command{
    private Curso curso;

    public InscribirseCursoCommand(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void execute() {
        curso.inscribir();
    }
}
