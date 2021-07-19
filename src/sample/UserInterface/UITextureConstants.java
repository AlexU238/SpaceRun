package sample.UserInterface;

public enum UITextureConstants {


    DEFAULT("\\UITextures\\default.png"),
    START_BUTTON("\\UITextures\\start.png"),
    SETTINGS_BUTTON("\\UITextures\\settings.png"),
    SCORE_BOARD_BUTTON("\\UITextures\\scoreBoard.png"),
    EXIT_BUTTON("\\UITextures\\exit.png"),
    BACKGROUND("\\UITextures\\background.gif"),
    TITLE("\\UITextures\\titleSpaceRun.png"),
    @SuppressWarnings("unused")
    BACK_BUTTON("\\UITextures\\back.png");

    private final String fileName;

    UITextureConstants(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }
}
