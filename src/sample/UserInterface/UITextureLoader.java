package sample.UserInterface;

import javafx.scene.image.Image;

import java.io.InputStream;

final class UITextureLoader {
    private static Image defaultTexture;
    private static Image startButtonTexture;
    private static Image settingsButtonTexture;
    private static Image scoreBoardButtonTexture;
    private static Image exitButtonTexture;
    private static Image background;
    private static Image backButtonTexture;
    private static Image title;

    private UITextureLoader() {

    }

    static void loadMainMenuTextures() {
        try {
            InputStream defaultButtonTextureInputStream = UITextureConstants.class.getResourceAsStream(UITextureConstants.DEFAULT.getFileName());
            defaultTexture = new Image(defaultButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: default texture NOT FOUND");

        }
        try {
            InputStream startButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.START_BUTTON.getFileName());
            startButtonTexture = new Image(startButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Start Button texture NOT FOUND");
            startButtonTexture = defaultTexture;
        }
        try {
            InputStream settingsButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SETTINGS_BUTTON.getFileName());
            settingsButtonTexture = new Image(settingsButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Settings button texture NOT FOUND");
            settingsButtonTexture = defaultTexture;
        }
        try {
            InputStream scoreBoardButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.SCORE_BOARD_BUTTON.getFileName());
            scoreBoardButtonTexture = new Image(scoreBoardButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Score Board button texture NOT FOUND");
            scoreBoardButtonTexture = defaultTexture;
        }
        try {
            InputStream exitButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.EXIT_BUTTON.getFileName());
            exitButtonTexture = new Image(exitButtonTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Exit button texture NOT FOUND");
            exitButtonTexture = defaultTexture;
        }
        try {
            InputStream titleInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.TITLE.getFileName());
            title = new Image(titleInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Title texture NOT FOUND");
            title = defaultTexture;
        }


    }

    static void loadMenuBackground() {
        try {
            InputStream menuBackgroundTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.BACKGROUND.getFileName());
            background = new Image(menuBackgroundTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("UserInterface: Menu background texture NOT FOUND");
            background = defaultTexture;
        }
    }

//    static void loadNavigationButtonTextures(){
//        try {
//            InputStream backButtonTextureInputStream = UITextureLoader.class.getResourceAsStream(UITextureConstants.BACKGROUND.getFileName());
//            backButtonTexture = new Image(backButtonTextureInputStream);
//        } catch (NullPointerException e) {
//            System.out.println("UserInterface: Menu background texture NOT FOUND");
//            backButtonTexture = defaultTexture;
//        }
//    }

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

    static Image getScoreBoardButtonTexture() {
        return scoreBoardButtonTexture;
    }

    static Image getExitButtonTexture() {
        return exitButtonTexture;
    }

    static Image getBackground() {
        return background;
    }

    @SuppressWarnings("unused")
    public static Image getBackButtonTexture() {
        return backButtonTexture;
    }

    static Image getTitle() {
        return title;
    }
}
