package sample.UserInterface;

import javafx.scene.image.Image;
import sample.CommonAlerts;

import java.io.InputStream;

public final class UITextureLoader {
    private static Image defaultTexture;
    private static Image startButtonTexture;
    private static Image settingsButtonTexture;
    private static Image playerInfoTexture;
    private static Image exitButtonTexture;
    private static Image background;
    private static Image backButtonTexture;
    private static Image mainMenuTitle;
    private static Image changeNameButton;
    private static Image settingsTitle;
    private static Image icon;

    private UITextureLoader() {

    }

    static void loadDefaultTexture() {
        try {
            InputStream defaultButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.DEFAULT.getFileName());
            defaultTexture = new Image(defaultButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: default texture NOT FOUND");
            CommonAlerts.loadDefaultTextureAlert();
        }
    }

    static void loadMainMenuTextures() {
        try {
            InputStream startButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.START_BUTTON.getFileName());
            startButtonTexture = new Image(startButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Start Button texture NOT FOUND");
            startButtonTexture = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }
        try {
            InputStream settingsButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SETTINGS_BUTTON.getFileName());
            settingsButtonTexture = new Image(settingsButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Settings button texture NOT FOUND");
            settingsButtonTexture = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }
        try {
            InputStream playerInfoTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.PLAYER_INFO.getFileName());
            playerInfoTexture = new Image(playerInfoTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Score Board button texture NOT FOUND");
            playerInfoTexture = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }
        try {
            InputStream exitButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.EXIT_BUTTON.getFileName());
            exitButtonTexture = new Image(exitButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Exit button texture NOT FOUND");
            exitButtonTexture = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }
        try {
            InputStream titleInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.TITLE.getFileName());
            mainMenuTitle = new Image(titleInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Title texture NOT FOUND");
            mainMenuTitle = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }


    }

    static void loadMenuBackground() {
        try {
            InputStream menuBackgroundTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.BACKGROUND.getFileName());
            background = new Image(menuBackgroundTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Menu Background: Menu background texture NOT FOUND");
            background = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }
    }

    static void loadSettingsPageTextures() {
        try {
            InputStream backButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.BACK_BUTTON.getFileName());
            backButtonTexture = new Image(backButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Settings: Back button texture NOT FOUND");
            backButtonTexture = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }
        try {
            InputStream changeNameButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.CHANGE_PLAYER_NAME_BUTTON.getFileName());
            changeNameButton = new Image(changeNameButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Settings: Change player name button texture NOT FOUND");
            changeNameButton = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }
        try {
            InputStream settingsTitleTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SETTINGS_TITLE.getFileName());
            settingsTitle = new Image(settingsTitleTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Settings: Settings title image not found texture NOT FOUND");
            settingsTitle = defaultTexture;
            CommonAlerts.loadInterfaceTexturesAlert();
        }
    }

    public static void loadIcon() {
        try {
            InputStream iconInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.ICON.getFileName());
            icon = new Image(iconInputStream);
        } catch (NullPointerException e) {
            System.out.println("Icon: Icon NOT FOUND");
        }
    }

    @SuppressWarnings("unused")
    static Image getDefaultTexture() {
        return defaultTexture;
    }

    static Image getStartButtonTexture() {
        return startButtonTexture;
    }

    static Image getSettingsButtonTexture() {
        return settingsButtonTexture;
    }

    static Image getPlayerInfoTexture() {
        return playerInfoTexture;
    }

    static Image getExitButtonTexture() {
        return exitButtonTexture;
    }

    static Image getBackground() {
        return background;
    }

    static Image getBackButtonTexture() {
        return backButtonTexture;
    }

    static Image getChangeNameButton() {
        return changeNameButton;
    }

    static Image getSettingsTitle() {
        return settingsTitle;
    }

    static Image getMainMenuTitle() {
        return mainMenuTitle;
    }

    public static Image getIcon() {
        return icon;
    }
}
