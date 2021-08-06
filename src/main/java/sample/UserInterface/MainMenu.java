package sample.UserInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Game.Game;
import sample.Main;


import java.util.Optional;

import static javafx.application.Platform.exit;

public final class MainMenu {
    private Scene mainMenuScene;
    private SettingsPage settingsPage = SettingsPage.giveAccessToSettings();
    private InterfaceMusic menuMusic = new InterfaceMusic();
    private Game game = new Game();
    private VBox functionalMenuLayout;
    private ImageView startButton;
    private ImageView settingsButton;
    private Label playerInfoLabel;
    private ImageView exitButton;
    private ImageView title;
    private BackgroundImage backgroundImage;


    public MainMenu() {
        UITextureLoader.loadDefaultTexture();
        UITextureLoader.loadMainMenuTextures();
        UITextureLoader.loadMenuBackground();

        playerInfoLabel = new Label("Name: " + Main.player.getName() + '\n' + "High Score: " + Main.player.getHighScore());
        playerInfoLabel.setFont(Font.font(40));
        playerInfoLabel.setTextFill(Color.YELLOW);
        playerInfoLabel.setBackground(new Background(new BackgroundImage(UITextureLoader.getPlayerInfoTexture(), null, null, null, BackgroundSize.DEFAULT)));
        functionalMenuLayout = new VBox();

        startButton = new ImageView(UITextureLoader.getStartButtonTexture());
        settingsButton = new ImageView(UITextureLoader.getSettingsButtonTexture());

        exitButton = new ImageView(UITextureLoader.getExitButtonTexture());
        title = new ImageView(UITextureLoader.getMainMenuTitle());
        backgroundImage = new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT);

        setUpMainMenuPage();

        mainMenuScene = new Scene(functionalMenuLayout, 1080, 720);
    }

    private void setUpMainMenuPage() {
        startButton.setOnMouseClicked(mouseEvent -> startGame());
        settingsButton.setOnMouseClicked(mouseEvent -> openSettingsPage());
        exitButton.setOnMouseClicked(mouseEvent -> initiateExit());

        functionalMenuLayout.getChildren().addAll(title, startButton, settingsButton, playerInfoLabel, exitButton);

        functionalMenuLayout.setSpacing(10);
        functionalMenuLayout.setAlignment(Pos.CENTER);
        functionalMenuLayout.setBackground(new Background(backgroundImage));
    }

    public void openMenu() {
        menuMusic.playMusic();
        Main.stage.setScene(mainMenuScene);
        Main.stage.show();
    }

    public void returnToMainMenuAfterGameOver(int score) {
        Main.player.updateScore(score);
        playerInfoLabel.setText("Name: " + Main.player.getName() + '\n' + "High Score: " + Main.player.getHighScore());

        Main.save();
        openMenu();
    }

    private void startGame() {
        menuMusic.stopPlayingMusic();
        game.startGame();
    }

    private void openSettingsPage() {
        settingsPage.openSettings();
    }

    private void initiateExit() {
        Alert exitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        exitAlert.setTitle("Space run exit");
        exitAlert.setHeaderText("Exit game");
        exitAlert.setContentText("Are you sure you wish to exit?");

        Optional<ButtonType> result = exitAlert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                exit();
            }
        }
    }

    public Label getPlayerInfoLabel() {
        return playerInfoLabel;
    }
}
