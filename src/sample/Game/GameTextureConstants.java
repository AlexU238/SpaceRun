package sample.Game;

enum GameTextureConstants {
    DEFAULT("GameTextures\\default.png"),
    STAR_TEXTURES("GameTextures\\StarTextures.png"),
    ROCK_TEXTURES("GameTextures\\RockTextures.png"),
    SHIP_TEXTURES("GameTextures\\ShipTexture.png"),
    EXPLOSION("GameTextures\\Explosion.gif");

    private final String fileName;

    GameTextureConstants(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }
}
