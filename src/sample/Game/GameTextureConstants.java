package sample.Game;

enum GameTextureConstants {
    DEFAULT("GameTextures\\default.png"),
    STAR_TEXTURES("GameTextures\\StarTextures.png"),
    ROCK_TEXTURES("GameTextures\\RockTextures.png"),
    SHIP_TEXTURES("GameTextures\\ShipTexture.png");

    private final String fileName;

    GameTextureConstants(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }
}
