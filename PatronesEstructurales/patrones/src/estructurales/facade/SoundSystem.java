package estructurales.facade;

public class SoundSystem {
    public void on() { System.out.println("Sonido encendido"); }
    public void setVolume(int level) { System.out.println("Volumen ajustado a: " + level); }
    public void off() { System.out.println("Sonido apagado"); }
}
