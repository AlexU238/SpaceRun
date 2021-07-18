package sample.UserInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import sample.Game.Game;
import sample.Main;

import static javafx.application.Platform.exit;

public final class MainMenu {
    private Scene mainMenuScene;
    private SettingsPage settingsPage = SettingsPage.giveAccessToSettings();
    private Game game = new Game();


    public MainMenu() {
        VBox functionalMenuLayout = new VBox();

        UITextureLoader.loadUserInterfaceTextures();
        ImageView startButton = new ImageView(UITextureLoader.getStartButtonTexture());
        ImageView settingsButton = new ImageView(UITextureLoader.getSettingsButtonTexture());
        ImageView scoreBoardButton = new ImageView(UITextureLoader.getScoreBoardButtonTexture());
        ImageView exitButton = new ImageView(UITextureLoader.getExitButtonTexture());
        BackgroundImage backgroundImage = new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT);

        startButton.setOnMouseClicked(mouseEvent -> startGame());
        settingsButton.setOnMouseClicked(mouseEvent -> openSettingsPage());
        scoreBoardButton.setOnMouseClicked(mouseEvent -> openScoreBoard());
        exitButton.setOnMouseClicked(mouseEvent -> initiateExit());

        functionalMenuLayout.getChildren().addAll(startButton, settingsButton, scoreBoardButton, exitButton);


        functionalMenuLayout.setSpacing(30);
        functionalMenuLayout.setAlignment(Pos.CENTER);
        functionalMenuLayout.setBackground(new Background(backgroundImage));

        mainMenuScene = new Scene(functionalMenuLayout, 1080, 720);
    }


    public void openMenu() {
        Main.stage.setScene(mainMenuScene);
        Main.stage.show();
    }


    private void startGame() {
        game.startGame();
    }

    private void openSettingsPage() {
        settingsPage.openSettings();
    }

    private void openScoreBoard() {
        //the score will be sent to a database, but I need to learn about JDBC more.
    }

    private void initiateExit() {
        exit();
    }
}
