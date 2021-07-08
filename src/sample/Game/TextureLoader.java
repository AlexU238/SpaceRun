package sample.Game;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

final class TextureLoader {
    private static Image star;
    private static Image rock;
    private static Image ship;

    private TextureLoader() {
    }

    static void loadMainThreeTextures(){
        try{
            FileInputStream imageInputStarTexture=new FileInputStream("C:\\Users\\User\\IdeaProjects\\SpaceRun\\src\\sample\\Game\\StarTextures.png");
            star=new Image(imageInputStarTexture);
        }catch(FileNotFoundException ex){
            System.out.println("Star texture file NOT FOUND");
            //return to menu??
        }
//        try{
//            FileInputStream imageInputRockTexture=new FileInputStream("ROCK.png");
//            rock=new Image(imageInputRockTexture);
//        }catch (FileNotFoundException ex){
//            System.out.println("Rock texture file NOT FOUND");
//        }try{
//            FileInputStream imageInputShipTexture=new FileInputStream("SHIP.png");
//            ship=new Image(imageInputShipTexture);
//        }catch (FileNotFoundException ex){
//            System.out.println("Ship texture file NOT FOUND");
//        }

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
