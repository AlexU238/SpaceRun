package sample.Game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URISyntaxException;

final class GameMusic {
    private Media mediaGame;
    private Media crashSound;
    private MediaPlayer mediaPlayerGame;
    private MediaPlayer crashSoundPlayer;

    GameMusic() {
        loadTrackMusic();
        loadTrackCrashSound();
        mediaPlayerGame = new MediaPlayer(mediaGame);
        crashSoundPlayer = new MediaPlayer(crashSound);
    }

    private void loadTrackMusic() {
        try {
            mediaGame = new Media(getClass().getResource("/Music/Bag Raiders  Shooting Stars 1 Hour.mp3").toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("Game Music: Wrong URI");
            e.getMessage();
        } catch (NullPointerException e) {
            System.out.println("Game Music: file not found");
        }
    }

    private void loadTrackCrashSound() {
        try {
            crashSound = new Media(getClass().getResource("/Music/Big Explosion Cut Off.mp3").toURI().toString());
        } catch (URISyntaxException e) {
            System.out.println("Crash sound: Wrong URI");
            e.getMessage();
        } catch (NullPointerException e) {
            System.out.println("Crash sound: file not found");
        }
    }

    void playMusic() {
        mediaPlayerGame.setAutoPlay(true);
        mediaPlayerGame.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerGame.play();
    }


    void stopPlayingMusic() {
        mediaPlayerGame.setAutoPlay(false);
        mediaPlayerGame.stop();
    }


    void crashSound() {
        crashSoundPlayer.play();
    }

}




