package sample.Game;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class Star extends SpaceObject {

    static private int starID;

    public Star(int x, int y, ImageView texture) {
        super(x, y, texture);
        starID++;
    }


    @Override
    void move() {

    }

    void reset(){

    }

    public static int getStarID() {
        return starID;
    }

}
