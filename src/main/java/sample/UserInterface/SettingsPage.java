package sample.UserInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Main;

import java.util.Optional;


final class SettingsPage {
    private Scene settingsMenu;
    private VBox settingsMenuLayout;
    private ImageView returnToMenuButton;
    private ImageView saveChanges;
    private TextField newName;
    private ImageView settingsTitle;
    private Slider gameVolumeSlider;
    private Slider menuVolumeSlider;
    private Label menuVolumeLevel;
    private Label gameVolumeLevel;
    private double currentMenuVolumeLevel=100;
    private double currentGameVolumeLevel=100;

    private SettingsPage() {
        UITextureLoader.loadDefaultTexture();
        UITextureLoader.loadSettingsPageTextures();
        settingsTitle = new ImageView(UITextureLoader.getSettingsTitle());
        returnToMenuButton = new ImageView(UITextureLoader.getBackButtonTexture());

        saveChanges = new ImageView(UITextureLoader.getChangeNameButton());
        newName = new TextField(Main.getPlayerName());

        settingsMenuLayout = new VBox();
        setUpSettingsPage();
        settingsMenu = new Scene(settingsMenuLayout, 1080, 720);
    }

    static SettingsPage giveAccessToSettings() {
        return new SettingsPage();
    }

    private void setUpSettingsPage() {
        setUpVolumeSliders();
        saveChanges.setOnMouseClicked(mouseEvent -> saveChangesInSettings(newName.getText()));
        returnToMenuButton.setOnMouseClicked(mouseEvent -> returnToMenu());
        UITextureLoader.loadMenuBackground();
        settingsMenuLayout.getChildren().addAll(settingsTitle, menuVolumeLevel, menuVolumeSlider, gameVolumeLevel, gameVolumeSlider, newName, saveChanges, returnToMenuButton);
        settingsMenuLayout.setSpacing(10);
        settingsMenuLayout.setAlignment(Pos.CENTER);
        newName.setMaxWidth(200);
        settingsMenuLayout.setBackground(new Background(new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT)));
    }

    void openSettings() {
        Main.setNewStageScene(settingsMenu);
    }

    private void saveChangesInSettings(String newName) {
        Alert saveAlert = new Alert(Alert.AlertType.CONFIRMATION);
        saveAlert.setTitle("Settings");
        saveAlert.setHeaderText("Confirm settings");
        saveAlert.setContentText("Save changes?");

        Optional<ButtonType> result = saveAlert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                Main.changePlayerName(newName);
                Main.getMainMenuLabel().setText("Name: " + Main.getPlayerName() + '\n' + "High Score: " + Main.getPlayerScore());
                setCurrentMenuVolumeLevel(menuVolumeSlider.getValue());
                setCurrentGameVolumeLevel(gameVolumeSlider.getValue());
            }
        }

    }

    private void setUpVolumeSliders() {
        menuVolumeSlider = new Slider(0.0, 100.0, getCurrentMenuVolumeLevel());
        menuVolumeSlider.setMajorTickUnit(5.0);
        menuVolumeSlider.setMinorTickCount(4);
        menuVolumeSlider.setBlockIncrement(2.0);
        menuVolumeSlider.setMaxWidth(500);
        menuVolumeSlider.setSnapToTicks(true);
        menuVolumeLevel = new Label("Menu music volume level: " + (int) menuVolumeSlider.getValue());
        menuVolumeSlider.valueProperty().addListener((changed, oldValue, newValue) -> menuVolumeLevel.setText("Menu music volume level: " + newValue.intValue()));
        menuVolumeSlider.valueProperty().addListener((changed, oldValue, newValue) -> Main.getMainMenu().getMenuMusic().changeVolume(newValue.doubleValue()/100));
        menuVolumeLevel.setFont(Font.font(14));
        menuVolumeLevel.setTextFill(Color.RED);

        gameVolumeSlider = new Slider(0.0, 100.0, getCurrentGameVolumeLevel());
        gameVolumeSlider.setMajorTickUnit(5.0);
        gameVolumeSlider.setMinorTickCount(4);
        gameVolumeSlider.setMaxWidth(500);
        gameVolumeSlider.setSnapToTicks(true);
        gameVolumeLevel = new Label("Game music volume level: " + (int) gameVolumeSlider.getValue());
        gameVolumeSlider.valueProperty().addListener((changed, oldValue, newValue) -> gameVolumeLevel.setText("Game music volume level: " + newValue.intValue()));
        gameVolumeSlider.valueProperty().addListener((changed, oldValue, newValue) -> Main.getMainMenu().getGame().getGameMusic().changeVolume(newValue.doubleValue()/100));
        gameVolumeLevel.setFont(Font.font(14));
        gameVolumeLevel.setTextFill(Color.RED);
    }

    private void returnToMenu() {
        Main.startMenu();
    }

    double getCurrentMenuVolumeLevel() {
        return currentMenuVolumeLevel;
    }

    void setCurrentMenuVolumeLevel(double currentMenuVolumeLevel) {
        this.currentMenuVolumeLevel = currentMenuVolumeLevel;
    }

     double getCurrentGameVolumeLevel() {
        return currentGameVolumeLevel;
    }

    void setCurrentGameVolumeLevel(double currentGameVolumeLevel) {
        this.currentGameVolumeLevel = currentGameVolumeLevel;
    }


}
