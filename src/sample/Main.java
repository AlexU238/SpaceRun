package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.UserInterface.MainMenu;


public class Main extends Application {
    public static Stage stage;
    public static MainMenu mainMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        mainMenu = new MainMenu();
        stage = new Stage();
        stage.setTitle("Space run");
        stage.resizableProperty().setValue(false);

        mainMenu.openMenu();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
