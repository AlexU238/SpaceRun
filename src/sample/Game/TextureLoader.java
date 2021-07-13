package sample.Game;

import javafx.scene.image.Image;

import java.io.InputStream;

final class TextureLoader {
    private static Image star;
    private static Image rock;
    private static Image ship;
    private static Image NO_TEXTURE;

    private TextureLoader() {
    }

    static void loadMainThreeTextures() {
        try {
            InputStream imageInputNoTexture = TextureLoader.class.getResourceAsStream(TextureConstants.DEFAULT.getFileName());
            NO_TEXTURE = new Image(imageInputNoTexture);
        } catch (NullPointerException ex) {
            System.out.println("NO_TEXTURE file not not found");
            //return to menu??
        }
        try {
            //FileInputStream imageInputStarTexture=new FileInputStream("C:\\Users\\User\\IdeaProjects\\SpaceRun\\src\\sample\\Game\\StarTextures.png");
            InputStream imageInputStarTexture = TextureLoader.class.getResourceAsStream(TextureConstants.STAR_TEXTURES.getFileName());
            star = new Image(imageInputStarTexture);
        } catch (NullPointerException e) {
            System.out.println("Star texture file NOT FOUND");
            star = NO_TEXTURE;
        }
        try {
            InputStream imageInputRockTexture = TextureLoader.class.getResourceAsStream(TextureConstants.ROCK_TEXTURES.getFileName());
            rock = new Image(imageInputRockTexture);
        } catch (NullPointerException ex) {
            System.out.println("Rock texture file NOT FOUND");
            rock = NO_TEXTURE;
        }
        try {
            InputStream imageInputShipTexture = TextureLoader.class.getResourceAsStream(TextureConstants.SHIP_TEXTURES.getFileName());
            ship = new Image(imageInputShipTexture);
        } catch (NullPointerException ex) {
            System.out.println("Ship texture file NOT FOUND");
            ship = NO_TEXTURE;
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
}
