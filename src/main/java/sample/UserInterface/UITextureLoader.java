package sample.UserInterface;

import javafx.scene.image.Image;
import sample.CommonAlerts;
import sample.TextureLoader;

import java.io.InputStream;

public final class UITextureLoader implements TextureLoader {
    private static UITextureLoader instance;
    private static Image defaultTexture;

    private UITextureLoader() {
        loadDefaultTexture();
    }

    public static UITextureLoader getInstance() {
        if (instance == null) {
            instance = new UITextureLoader();
        }
        return instance;
    }

    @Override
    public void loadDefaultTexture() {
        try {
            InputStream defaultTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.DEFAULT.getFileName());
            defaultTexture = new Image(defaultTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: default texture NOT FOUND");
            CommonAlerts.loadDefaultTextureAlert();
        }
    }

    static Image loadMainMenuStartButtonTexture(){
        try {
            InputStream startButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.START_BUTTON.getFileName());
            return new Image(startButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Start Button texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadMainMenuSettingsButtonTexture(){
        try {
            InputStream settingsButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SETTINGS_BUTTON.getFileName());
            return new Image(settingsButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Settings button texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadMainMenuPlayerInfoTexture(){
        try {
            InputStream playerInfoTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.PLAYER_INFO.getFileName());
            return new Image(playerInfoTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Score Board button texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadMainMenuExitButtonTexture(){
        try {
            InputStream exitButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.EXIT_BUTTON.getFileName());
            return new Image(exitButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Exit button texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadMainMenuTitleTexture(){
        try {
            InputStream titleInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.TITLE.getFileName());
            return new Image(titleInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Title texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }


    static Image loadMenuBackground() {
        try {
            InputStream menuBackgroundTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.BACKGROUND.getFileName());
            return new Image(menuBackgroundTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Menu Background: Menu background texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadSettingsPageBackButtonTexture(){
        try {
            InputStream backButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.BACK_BUTTON.getFileName());
            return new Image(backButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Settings: Back button texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadSettingsPageSaveChangesButton(){
        try {
            InputStream saveChangesButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SAVE_CHANGES_BUTTON.getFileName());
            return new Image(saveChangesButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Settings: Save changes button texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadSettingsPageSettingsTitleTexture(){
        try {
            InputStream settingsTitleTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SETTINGS_TITLE.getFileName());
            return new Image(settingsTitleTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Settings: Settings title image not found texture NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }


    public static Image loadIcon() {
        try {
            InputStream iconInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.ICON.getFileName());
            return new Image(iconInputStream);
        } catch (NullPointerException e) {
            System.out.println("Icon: Icon NOT FOUND");
            CommonAlerts.loadInterfaceTexturesAlert();
            return defaultTexture;
        }
    }


    private enum UITextureConstants {

        DEFAULT("/DefaultTexture/default.png"),
        START_BUTTON("/UITextures/startButton.png"),
        SETTINGS_BUTTON("/UITextures/settingsButton.png"),
        PLAYER_INFO("/UITextures/scoreBoard.png"),
        EXIT_BUTTON("/UITextures/exitButton.png"),
        BACKGROUND("/UITextures/background.gif"),
        TITLE("/UITextures/titleSpaceRun.png"),
        BACK_BUTTON("/UITextures/backButton.png"),
        SAVE_CHANGES_BUTTON("/UITextures/saveSettings.png"),
        SETTINGS_TITLE("/UITextures/settingsTitle.png"),
        ICON("/UITextures/icon.png");

        private final String fileName;

        UITextureConstants(String fileName) {
            this.fileName = fileName;
        }

        String getFileName() {
            return fileName;
        }
    }

}
