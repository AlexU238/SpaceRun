package sample.Game;

import javafx.scene.image.Image;

import java.io.InputStream;

final class GameTextureLoader {
    private static Image star;
    private static Image rock;
    private static Image ship;
    private static Image defaultTexture;
    private static Image explosion;

    private GameTextureLoader() {
    }

    static void loadMainThreeTextures() {
        try {
            InputStream imageInputNoTexture = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.DEFAULT.getFileName());
            defaultTexture = new Image(imageInputNoTexture);
        } catch (NullPointerException ex) {
            System.out.println("Game: texture file for defaultTexture is not NOT FOUND");
            //return to menu??
        }
        try {
            InputStream imageInputStarTexture = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.STAR_TEXTURES.getFileName());
            star = new Image(imageInputStarTexture);
        } catch (NullPointerException e) {
            System.out.println("Game: texture file for Star is NOT FOUND");
            star = defaultTexture;
        }
        try {
            InputStream imageInputRockTexture = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.ROCK_TEXTURES.getFileName());
            rock = new Image(imageInputRockTexture);
        } catch (NullPointerException ex) {
            System.out.println("Game: texture file for Rock is NOT FOUND");
            rock = defaultTexture;
        }
        try {
            InputStream imageInputShipTexture = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.SHIP_TEXTURES.getFileName());
            ship = new Image(imageInputShipTexture);
        } catch (NullPointerException ex) {
            System.out.println("Game: texture file for Ship is NOT FOUND");
            ship = defaultTexture;
        }
        try {
            InputStream imageInputExplosionTexture = GameTextureLoader.class.getResourceAsStream(GameTextureConstants.EXPLOSION.getFileName());
            explosion = new Image(imageInputExplosionTexture);
        } catch (NullPointerException e) {
            System.out.println("Game: texture file for Explosion is NOT FOUND");
            explosion = defaultTexture;
        }

    }

    static Image getStar() {
        return star;
    }

    static Image getRock() {
        return rock;
    }

    static Image getShip() {
        return ship;
    }

    static Image getExplosion() {
        return explosion;
    }
}
