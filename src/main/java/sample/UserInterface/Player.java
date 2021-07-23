package sample.UserInterface;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int highScore;

    public Player(String name, int highScore) {
        this.name = name;
        this.highScore = highScore;
    }

    void updateScore(int score) {
        if (score >= highScore) {
            this.setHighScore(score);
        }
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getHighScore() {
        return highScore;
    }

    private void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}
