package sample.UserInterface;

public enum UITextureConstants {


    DEFAULT("/UITextures/default.png"),
    START_BUTTON("/UITextures/start.png"),
    SETTINGS_BUTTON("/UITextures/settings.png"),
    PLAYER_INFO("/UITextures/scoreBoard.png"),
    EXIT_BUTTON("/UITextures/exit.png"),
    BACKGROUND("/UITextures/background.gif"),
    TITLE("/UITextures/titleSpaceRun.png"),
    BACK_BUTTON("/UITextures/back.png"),
    CHANGE_PLAYER_NAME_BUTTON("/UITextures/changeName.png"),
    SETTINGS_TITLE("/UITextures/settingsTitle.png");

    private final String fileName;

    UITextureConstants(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }
}
