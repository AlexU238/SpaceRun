package sample.Game;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.Main;


public class Game {
    private Scene gameScene;
    private Text score = new Text();

    private Space space = Space.connectToSpace();

    public Game() {

        Group gameGroup = new Group();
        score.setFill(Color.WHITE);
        score.setFont(Font.font(48));
        score.setX(800);
        score.setY(100);
        gameGroup.getChildren().addAll(space.getBackground(), space.getStars(), space.getRocks(), space.getShip(), score);
        gameScene = new Scene(gameGroup, 1080, 720);
        gameScene.setOnKeyPressed(space.startShip());
    }

    private void startAnimation() {
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                score.setText(space.printScore());
                space.moveBackGround();
                space.moveRocks();
                space.adjustDifficulty();
                space.moveShipAdditionalTexture();
                if (space.collide()) {
                    stop();
                    gameOver();
                }
            }
        };
        animationTimer.start();
    }

    private void gameOver() {
        Alert gameOverAlert = new Alert(Alert.AlertType.INFORMATION);
        gameOverAlert.setTitle(null);
        gameOverAlert.setHeaderText("GAME OVER");
        gameOverAlert.setContentText(space.printScore().toUpperCase());
        gameOverAlert.setOnHidden(dialogEvent -> Main.mainMenu.returnToMainMenuAfterGameOver(space.getScore()));
        gameOverAlert.show();
    }

    public void startGame() {
        startAnimation();
        Main.stage.setScene(gameScene);
        Main.stage.show();
    }

    @SuppressWarnings("unused")
    public Space getSpace() {
        return space;
    }
}
