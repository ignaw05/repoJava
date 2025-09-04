package estructurales.facade;

public class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private SoundSystem sound;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem sound) {
        this.dvd = dvd;
        this.projector = projector;
        this.sound = sound;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparando para ver una película...");
        dvd.on();
        projector.on();
        sound.on();
        sound.setVolume(100);
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Apagando el sistema de cine en casa...");
        dvd.off();
        projector.off();
        sound.off();
    }
}

