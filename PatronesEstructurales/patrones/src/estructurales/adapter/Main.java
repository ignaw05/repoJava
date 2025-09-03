package estructurales.adapter;

public class Main {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp3", "cancion1.mp3");
        player.play("mp4", "video1.mp4");
        player.play("vlc", "pelicula1.vlc");
        player.play("avi", "archivo.avi"); // no soportado
    }
}

