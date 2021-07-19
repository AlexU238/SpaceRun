package sample.UserInterface;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import sample.Main;

final class SettingsPage {
    private Scene settingsMenu;
    private VBox settingsMenuLayout;
    //private ImageView backToMainMenuButton;

    private SettingsPage() {
        settingsMenuLayout = new VBox();
        setUpSettingsPage();
        settingsMenu = new Scene(settingsMenuLayout, 1080, 720);
    }

    static SettingsPage giveAccessToSettings() {
        return new SettingsPage();
    }

    private void setUpSettingsPage() {
        //ADD BUTTONS AND STUFF
        UITextureLoader.loadMenuBackground();

        settingsMenuLayout.setBackground(new Background(new BackgroundImage(UITextureLoader.getBackground(), null, null, null, BackgroundSize.DEFAULT)));
    }

    void openSettings() {
        Main.stage.setScene(settingsMenu);
        Main.stage.show();
    }

    void returnToMenu() {
        Main.mainMenu.openMenu();
    }
}
