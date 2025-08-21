package abstractfactory;

public class Main {
    public static void main(String[] args) {
        GUIFactory factory;

        // Imagina que el SO lo obtenemos dinámicamente
        String os = "Linux"; // cambiar por "Linux"

        if (os.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new LinuxFactory();
        }

        Application app = new Application(factory);
        app.render();
    }
}
