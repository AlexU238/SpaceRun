package sample.UserInterface;

import javafx.scene.image.Image;

import java.io.InputStream;

public final class UITextureLoader {
    private static Image defaultTexture;
    private static Image startButtonTexture;
    private static Image settingsButtonTexture;
    private static Image scoreBoardButtonTexture;
    private static Image exitButtonTexture;

    private UITextureLoader() {

    }

    static void loadUserInterfaceTextures() {
        try {
            InputStream defaultButtonTextureInputStream = UITextureConstants.class.getResourceAsStream(UITextureConstants.DEFAULT.getFileName());
            defaultTexture = new Image(defaultButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: ");

        }
        try {
            InputStream startButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.START_BUTTON.getFileName());
            startButtonTexture = new Image(startButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: ");
            startButtonTexture = defaultTexture;
        }
        try {
            InputStream settingsButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SETTINGS_BUTTON.getFileName());
            settingsButtonTexture = new Image(settingsButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: ");
            settingsButtonTexture = defaultTexture;
        }
        try {
            InputStream scoreBoardButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SCORE_BOARD_BUTTON.getFileName());
            scoreBoardButtonTexture = new Image(scoreBoardButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: ");
            scoreBoardButtonTexture = defaultTexture;
        }
        try {
            InputStream exitButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.EXIT_BUTTON.getFileName());
            exitButtonTexture = new Image(exitButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: ");
            exitButtonTexture = defaultTexture;
        }

    }

    static Image getDefaultTexture() {
        return defaultTexture;
    }

    static Image getStartButtonTexture() {
        return startButtonTexture;
    }

    static Image getSettingsButtonTexture() {
        return settingsButtonTexture;
    }

    static Image getScoreBoardButtonTexture() {
        return scoreBoardButtonTexture;
    }

    static Image getExitButtonTexture() {
        return exitButtonTexture;
    }
}
