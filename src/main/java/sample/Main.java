package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.UserInterface.MainMenu;
import sample.UserInterface.Player;
import sample.UserInterface.UITextureLoader;

import java.io.*;

public class Main extends Application {

    public static Stage stage;
    public static MainMenu mainMenu;
    public static Player player;

    @Override
    public void start(Stage primaryStage) throws Exception {

        UITextureLoader.loadIcon();
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

        mainMenu = new MainMenu();
        stage = new Stage();
        stage.setTitle("Space run");
        stage.resizableProperty().setValue(false);
        stage.getIcons().add(UITextureLoader.getIcon());

        mainMenu.openMenu();

    }



     public static void save() {
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
}
