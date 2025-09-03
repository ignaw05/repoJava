package estructurales.adapter;

public class AdvancedMediaPlayer {
    void playMp4(String fileName) {
        System.out.println("Reproduciendo archivo MP4: " + fileName);
    }

    void playVlc(String fileName) {
        System.out.println("Reproduciendo archivo VLC: " + fileName);
    }
}
