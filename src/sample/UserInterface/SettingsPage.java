package sample.UserInterface;

import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import sample.Main;

final class SettingsPage {
    private Scene settingsMenu;

    private SettingsPage() {

        //ADD BUTTONS AND STUFF
        UITextureLoader.loadUserInterfaceTextures();
        VBox settingsMenuLayout = new VBox();
        settingsMenuLayout.setBackground(new Background(new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT)));
        settingsMenu = new Scene(settingsMenuLayout, 1080, 720);
    }

    static SettingsPage giveAccessToSettings() {
        return new SettingsPage();
    }

    void openSettings() {
        Main.stage.setScene(settingsMenu);
        Main.stage.show();
    }

    void returnToMenu() {

    }
}
