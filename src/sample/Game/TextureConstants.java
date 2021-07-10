package sample.Game;

enum TextureConstants {
    DEFAULT("no_texture.png"),
    STAR_TEXTURES("StarTextures.png"),
    ROCK_TEXTURES("RockTextures.png"),
    SHIP_TEXTURES("ShipTexture.png");

    private final String fileName;

    TextureConstants(String fileName) {
        this.fileName = fileName;
    }

    String getFileName() {
        return fileName;
    }
}
