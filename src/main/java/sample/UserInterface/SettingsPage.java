package sample.UserInterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import sample.Main;


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
        changeName.setOnMouseClicked(mouseEvent -> changePlayerName(newName.getText()));
        returnToMenuButton.setOnMouseClicked(mouseEvent -> returnToMenu());
        UITextureLoader.loadMenuBackground();
        settingsMenuLayout.getChildren().addAll(settingsTitle, newName, changeName, returnToMenuButton);
        settingsMenuLayout.setSpacing(20);
        settingsMenuLayout.setAlignment(Pos.CENTER);
        newName.setMaxWidth(200);
        settingsMenuLayout.setBackground(new Background(new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT)));
    }

    void openSettings() {
        Main.stage.setScene(settingsMenu);
        Main.stage.show();
    }

    private void changePlayerName(String newName) {
        Main.player.setName(newName);
    }

    private void returnToMenu() {
        Main.mainMenu.openMenu();
    }
}
