package sample.Game;

import javafx.scene.image.Image;
import sample.CommonAlerts;
import sample.TextureLoader;

import java.io.InputStream;

public final class GameTextureLoader implements TextureLoader {
    private static GameTextureLoader instance;
    private static Image star;
    private static Image rock;
    private static Image ship;
    private static Image defaultTexture;
    private static Image explosion;

    private GameTextureLoader() {
        loadDefaultTexture();
    }

    @Override
    public void loadDefaultTexture() {
        try {
            InputStream defaultTextureInputStream = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.DEFAULT.getFileName());
            defaultTexture = new Image(defaultTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Game: texture file for defaultTexture is not NOT FOUND");
            CommonAlerts.loadDefaultTextureAlert();
        }
    }

    public static GameTextureLoader getInstance() {
        if (instance == null) {
            instance = new GameTextureLoader();
        }
        return instance;
    }

    static Image loadGameStarTexture(){
        try {
            InputStream starTextureInputStream = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.STAR_TEXTURES.getFileName());
            return new Image(starTextureInputStream);
        } catch (NullPointerException e) {
            System.out.println("Game: texture file for Star is NOT FOUND");
            CommonAlerts.loadGameTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadGameRockTexture(){
        try {
            InputStream imageInputRockTexture = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.ROCK_TEXTURES.getFileName());
            return new Image(imageInputRockTexture);
        } catch (NullPointerException ex) {
            System.out.println("Game: texture file for Rock is NOT FOUND");
            CommonAlerts.loadGameTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadGameShipTexture(){
        try {
            InputStream imageInputShipTexture = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.SHIP_TEXTURES.getFileName());
            return new Image(imageInputShipTexture);
        } catch (NullPointerException ex) {
            System.out.println("Game: texture file for Ship is NOT FOUND");
            CommonAlerts.loadGameTexturesAlert();
            return defaultTexture;
        }
    }

    static Image loadGameExplosionTexture(){
        try {
            InputStream imageInputExplosionTexture = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.EXPLOSION.getFileName());
            return new Image(imageInputExplosionTexture);
        } catch (NullPointerException e) {
            System.out.println("Game: texture file for Explosion is NOT FOUND");
            CommonAlerts.loadGameTexturesAlert();
            return defaultTexture;
        }
    }


    private enum GameTextureConstants {
        DEFAULT("/DefaultTexture/default.png"),
        STAR_TEXTURES("/GameTextures/StarTextures.png"),
        ROCK_TEXTURES("/GameTextures/RockTextures.png"),
        SHIP_TEXTURES("/GameTextures/ShipTexture.png"),
        EXPLOSION("/GameTextures/Explosion.gif");

        private final String fileName;

        GameTextureConstants(String fileName) {
            this.fileName = fileName;
        }

        String getFileName() {
            return fileName;
        }
    }


}
