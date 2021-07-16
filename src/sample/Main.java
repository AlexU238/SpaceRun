package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Game.*;
import sample.UserInterface.MainMenu;

import java.awt.*;

public class Main extends Application {
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        MainMenu mainMenu = new MainMenu();

        stage = new Stage();
        stage.setTitle("Space run");
        stage.resizableProperty().setValue(false);

        mainMenu.openMenu();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
