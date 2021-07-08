package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Game.*;

import java.awt.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Space space = Space.connectToSpace();
        Group groupMain = new Group();
        groupMain.getChildren().addAll(space.getBackground(),space.getStars());
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Space run");
        primaryStage.setScene(new Scene(groupMain, 1080, 720));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();

    }


    public static void main(String[] args) {
    launch(args);


    System.out.println(MouseInfo.getPointerInfo().getLocation().toString());

    }
}
