package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Game.*;

import java.awt.*;

public class Main extends Application {
    private static Space space = Space.connectToSpace();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group groupMain = new Group();
        groupMain.getChildren().addAll(space.getBackground(), space.getStars(), space.getRocks(), space.getShip());
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
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


        primaryStage.setTitle("Space run");
        Scene mainScene = new Scene(groupMain, 1080, 720);
        mainScene.setOnKeyPressed(space.startShip());
        primaryStage.setScene(mainScene);
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);


        System.out.println(MouseInfo.getPointerInfo().getLocation().toString());
        System.out.println(space.getDifficulty());


    }
}
