package sample.UserInterface;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import sample.Game.Game;
import sample.Main;

import static javafx.application.Platform.exit;

public final class MainMenu {
    private Scene mainMenuScene;
    private ImageView startButton;
    private ImageView settingsButton;
    private ImageView scoreBoardButton;
    private ImageView exitButton;
    private VBox menuLayout;
    Game game = new Game();


    public MainMenu() {
        menuLayout = new VBox();
        UITextureLoader.loadUserInterfaceTextures();
        startButton = new ImageView(UITextureLoader.getStartButtonTexture());
        settingsButton = new ImageView(UITextureLoader.getSettingsButtonTexture());
        scoreBoardButton = new ImageView(UITextureLoader.getScoreBoardButtonTexture());
        exitButton = new ImageView(UITextureLoader.getExitButtonTexture());

        startButton.setOnMouseClicked(mouseEvent -> startGame());
        settingsButton.setOnMouseClicked(mouseEvent -> openSettingsPage());
        scoreBoardButton.setOnMouseClicked(mouseEvent -> openScoreBoard());
        exitButton.setOnMouseClicked(mouseEvent -> initiateExit());
        menuLayout.getChildren().addAll(startButton, settingsButton, scoreBoardButton, exitButton);
        mainMenuScene = new Scene(menuLayout, 1080, 720);
    }

    public void openMenu() {
        Main.stage.setScene(mainMenuScene);
        Main.stage.show();
    }

    private void startGame() {
        game.startGame();
    }

    private void openSettingsPage() {

    }

    private void openScoreBoard() {

    }

    private void initiateExit() {
        exit();
    }
}
