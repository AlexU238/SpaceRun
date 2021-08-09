package sample.UserInterface;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int highScore;
//    private double preferredMenuMusicVolume;
//    private double preferredGameMusicVolume;

    public Player(String name, int highScore) {
        this.name = name;
        this.highScore = highScore;
//        this.preferredMenuMusicVolume=preferredMenuMusicVolume;
//        this.preferredGameMusicVolume=preferredGameMusicVolume;
    }

    public void updateScore(int score) {
        if (score >= highScore) {
            this.setHighScore(score);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighScore() {
        return highScore;
    }

    private void setHighScore(int highScore) {
        this.highScore = highScore;
    }

//     double getPreferredMenuMusicVolume() {
//        return preferredMenuMusicVolume;
//    }
//
//     double getPreferredGameMusicVolume() {
//        return preferredGameMusicVolume;
//    }

//     void setPreferredMenuMusicVolume(double preferredMenuMusicVolume) {
//        this.preferredMenuMusicVolume = preferredMenuMusicVolume;
//    }
//
//     void setPreferredGameMusicVolume(double preferredGameMusicVolume) {
//        this.preferredGameMusicVolume = preferredGameMusicVolume;
//    }
}
