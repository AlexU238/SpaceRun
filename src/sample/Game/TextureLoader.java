package sample.Game;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

final class TextureLoader { //need get the file location to be automatic
    private static Image star;
    private static Image rock;
    private static Image ship;
    private static Image NO_TEXTURE;

    private TextureLoader() {
    }

    static void loadMainThreeTextures(){
        try {
            FileInputStream imageInputNoTexture=new FileInputStream("C:\\Users\\User\\IdeaProjects\\SpaceRun\\src\\sample\\Game\\no_texture.png");
            NO_TEXTURE=new Image(imageInputNoTexture);
        }catch (FileNotFoundException ex){
            System.out.println("NO_TEXTURE file not not found");
            //return to menu??
        }
        try{
            FileInputStream imageInputStarTexture=new FileInputStream("C:\\Users\\User\\IdeaProjects\\SpaceRun\\src\\sample\\Game\\StarTextures.png");
            star=new Image(imageInputStarTexture);
        }catch(FileNotFoundException ex){
            System.out.println("Star texture file NOT FOUND");
            star=NO_TEXTURE;
        }
        try{
            FileInputStream imageInputRockTexture=new FileInputStream("C:\\Users\\User\\IdeaProjects\\SpaceRun\\src\\sample\\Game\\RockTextures.png");
            rock=new Image(imageInputRockTexture);
        }catch (FileNotFoundException ex){
            System.out.println("Rock texture file NOT FOUND");
            rock=NO_TEXTURE;
        }
        try{
            FileInputStream imageInputShipTexture=new FileInputStream("SHIP.png");
            ship=new Image(imageInputShipTexture);
        }catch (FileNotFoundException ex){
            System.out.println("Ship texture file NOT FOUND");
            ship=NO_TEXTURE;
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
