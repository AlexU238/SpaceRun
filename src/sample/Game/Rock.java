package sample.Game;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rock extends SpaceObject {

    static private int rockID;

    Rock(int x, int y, ImageView texture) {
        super(x, y, texture);
        rockID++;
    }


    @Override
     void move() {


    }

    void launch(){

    }

    void reset(){

    }

    public static int getRockID() {
        return rockID;
    }


}
