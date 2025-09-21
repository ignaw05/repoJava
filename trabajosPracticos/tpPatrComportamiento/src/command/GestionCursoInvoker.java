package command;

public class GestionCursoInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void ejecutar(){
        command.execute();
    }
}
