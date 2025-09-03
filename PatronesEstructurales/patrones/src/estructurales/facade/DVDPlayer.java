package estructurales.facade;

public class DVDPlayer {
    public void on() { System.out.println("DVD Player encendido"); }
    public void play(String movie) { System.out.println("Reproduciendo película: " + movie); }
    public void off() { System.out.println("DVD Player apagado"); }
}
