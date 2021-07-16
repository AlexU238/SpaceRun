package sample.Game;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import sample.Main;

public class Game {
    Scene gameScene;
    Group gameGroup;
    Space space = Space.connectToSpace();

    public Game() {

        gameGroup = new Group();
        gameGroup.getChildren().addAll(space.getBackground(), space.getStars(), space.getRocks(), space.getShip());
        gameScene = new Scene(gameGroup, 1080, 720);
    }

    void startAnimation() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                space.moveBackGround();
                space.moveRocks();
                space.adjustDifficulty();
                space.collide();
            }
        };
        animationTimer.start();
    }

    public void startGame() {
        startAnimation();
        Main.stage.setScene(gameScene);
        Main.stage.show();
    }
}
