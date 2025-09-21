package memento;

public class Historial {
    private java.util.Stack<Memento> historial = new java.util.Stack<>();
    public void guardar(Memento memento){historial.push(memento);}
    public Memento deshacer(){
        if (!historial.isEmpty()){
            return historial.pop();
        }
        return null;
    }
}
