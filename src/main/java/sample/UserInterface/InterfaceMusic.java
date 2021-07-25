package sample.UserInterface;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URISyntaxException;

final class InterfaceMusic {

    private Media menuMusic;
    private MediaPlayer menuMusicPlayer;

    InterfaceMusic() {
        loadTrackMusic();
        menuMusicPlayer = new MediaPlayer(menuMusic);
    }

    private void loadTrackMusic() {
        try {
            menuMusic = new Media(getClass().getResource("/Music/The World's Fair - Godmode.mp3").toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("Menu Music: Wrong URI");
            e.getMessage();
        } catch (NullPointerException e) {
            System.out.println("Game Music: file not found");
        }
    }

    void playMusic() {
        menuMusicPlayer.setAutoPlay(true);
        menuMusicPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        menuMusicPlayer.play();
    }


    void stopPlayingMusic() {
        menuMusicPlayer.setAutoPlay(false);
        menuMusicPlayer.stop();
    }
}
