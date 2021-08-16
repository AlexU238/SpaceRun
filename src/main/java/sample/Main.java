package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Game.GameTextureLoader;
import sample.UserInterface.MainMenu;
import sample.UserInterface.Player;
import sample.UserInterface.UITextureLoader;

import java.io.*;

public class Main extends Application {

    private static Stage stage;
    private static MainMenu mainMenu;
    private static Player player;

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            FileInputStream fileInputStream = new FileInputStream("PlayerData.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            player = (Player) objectInputStream.readObject();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: Trying to load wrong type of object. Object has to be Player");
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file: PlayerData.ser");
            player = new Player("player", 0);
        }
        TextureLoader uiTextureLoader = UITextureLoader.getInstance(); // these two instances were created to load default textures
        GameTextureLoader gameTextureLoader = GameTextureLoader.getInstance(); //create a better implementation if possible
        mainMenu = new MainMenu();
        stage = new Stage();
        stage.setTitle("Space run");
        stage.resizableProperty().setValue(false);
        stage.getIcons().add(UITextureLoader.loadIcon());



        startMenu();

    }

    private static void save() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("PlayerData.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(player);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Cannot save player data");
        }
    }

    public static void main(String[] args) {
        launch(args);
        Main.save();
    }

    public static void startMenu(){
        mainMenu.openMenu();
    }

    public static void setNewStageScene(Scene newScene){
        stage.setScene(newScene);
        stage.show();
    }

    private static void changePlayerScore(int score){
        player.updateScore(score);
    }

    public static void changePlayerName(String name){
        player.setName(name);
    }

    public static String getPlayerName() {
        return player.getName();
    }

    public static int getPlayerScore() {
        return player.getHighScore();
    }

    public static Label getMainMenuLabel(){
        return mainMenu.getPlayerInfoLabel();
    }

    public static void returnToMainMenuAfterGameOver(int score){
        changePlayerScore(score);
        getMainMenuLabel().setText("Name: " + Main.getPlayerName() + '\n' + "High Score: " + Main.getPlayerScore());
        save();
        startMenu();
    }

    public static MainMenu getMainMenu() {
        return mainMenu;
    }
}
