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
    private VBox functionalMenuLayout;
    private ImageView startButton;
    private ImageView settingsButton;
    private ImageView scoreBoardButton;
    private ImageView exitButton;
    private ImageView title;
    private BackgroundImage backgroundImage;


    public MainMenu() {
        functionalMenuLayout = new VBox();
        UITextureLoader.loadMainMenuTextures();
        UITextureLoader.loadMenuBackground();
        startButton = new ImageView(UITextureLoader.getStartButtonTexture());
        settingsButton = new ImageView(UITextureLoader.getSettingsButtonTexture());
        scoreBoardButton = new ImageView(UITextureLoader.getScoreBoardButtonTexture());
        exitButton = new ImageView(UITextureLoader.getExitButtonTexture());
        title = new ImageView(UITextureLoader.getTitle());
        backgroundImage = new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT);


        setUpMainMenuPage();


        mainMenuScene = new Scene(functionalMenuLayout, 1080, 720);
    }

    private void setUpMainMenuPage() {
        startButton.setOnMouseClicked(mouseEvent -> startGame());
        settingsButton.setOnMouseClicked(mouseEvent -> openSettingsPage());
        scoreBoardButton.setOnMouseClicked(mouseEvent -> openScoreBoard());
        exitButton.setOnMouseClicked(mouseEvent -> initiateExit());

        functionalMenuLayout.getChildren().addAll(title, startButton, settingsButton, scoreBoardButton, exitButton);

        functionalMenuLayout.setSpacing(10);
        functionalMenuLayout.setAlignment(Pos.CENTER);
        functionalMenuLayout.setBackground(new Background(backgroundImage));
    }

    public void openMenu() {
        Main.stage.setScene(mainMenuScene);
        Main.stage.show();
    }

    public void returnToMainMenuAfterGameOver() {
        //save the score
        openMenu();
    }


    private void startGame() {
        game.startGame();
    }

    private void openSettingsPage() {
        settingsPage.openSettings();
    }

    private void openScoreBoard() {
        //the scores will be sent to a database, but I need to learn about JDBC more.
    }

    private void initiateExit() {
        exit();
    }
}
