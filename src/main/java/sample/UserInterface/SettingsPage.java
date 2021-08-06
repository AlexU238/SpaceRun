package sample.UserInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import sample.Main;

import java.util.Optional;


final class SettingsPage {
    private Scene settingsMenu;
    private VBox settingsMenuLayout;
    private ImageView returnToMenuButton;
    private ImageView changeName;
    private TextField newName;
    private ImageView settingsTitle;

    private SettingsPage() {
        UITextureLoader.loadDefaultTexture();
        UITextureLoader.loadSettingsPageTextures();
        settingsTitle = new ImageView(UITextureLoader.getSettingsTitle());
        returnToMenuButton = new ImageView(UITextureLoader.getBackButtonTexture());
        changeName = new ImageView(UITextureLoader.getChangeNameButton());
        newName = new TextField(Main.player.getName());

        settingsMenuLayout = new VBox();
        setUpSettingsPage();
        settingsMenu = new Scene(settingsMenuLayout, 1080, 720);
    }

    static SettingsPage giveAccessToSettings() {
        return new SettingsPage();
    }

    private void setUpSettingsPage() {
        changeName.setOnMouseClicked(mouseEvent -> saveChangesInSettings(newName.getText()));
        returnToMenuButton.setOnMouseClicked(mouseEvent -> returnToMenu());
        UITextureLoader.loadMenuBackground();
        settingsMenuLayout.getChildren().addAll(settingsTitle, newName, changeName, returnToMenuButton);
    //    settingsMenuLayout.setSpacing(10);
        settingsMenuLayout.setAlignment(Pos.CENTER);
        newName.setMaxWidth(200);
        settingsMenuLayout.setBackground(new Background(new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT)));
    }

    void openSettings() {
        Main.stage.setScene(settingsMenu);
        Main.stage.show();
    }

    private void saveChangesInSettings(String newName) {
        Alert saveAlert = new Alert(Alert.AlertType.CONFIRMATION);
        saveAlert.setTitle("Settings");
        saveAlert.setHeaderText("Confirm settings");
        saveAlert.setContentText("Save changes?");

        Optional<ButtonType> result = saveAlert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                Main.player.setName(newName);
                Main.mainMenu.getPlayerInfoLabel().setText("Name: " + Main.player.getName() + '\n' + "High Score: " + Main.player.getHighScore());
            }
        }

    }

    private void returnToMenu() {
        Main.mainMenu.openMenu();
    }
}
