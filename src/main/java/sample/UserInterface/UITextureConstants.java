package sample.UserInterface;

public enum UITextureConstants {


    DEFAULT("/UITextures/default.png"),
    START_BUTTON("/UITextures/startButton.png"),
    SETTINGS_BUTTON("/UITextures/settingsButton.png"),
    PLAYER_INFO("/UITextures/scoreBoard.png"),
    EXIT_BUTTON("/UITextures/exitButton.png"),
    BACKGROUND("/UITextures/background.gif"),
    TITLE("/UITextures/titleSpaceRun.png"),
    BACK_BUTTON("/UITextures/backButton.png"),
    CHANGE_PLAYER_NAME_BUTTON("/UITextures/saveSettings.png"),
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
