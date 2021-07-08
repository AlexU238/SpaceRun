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
        if (this.getTexture().getX()>-100){
            this.getTexture().setX(this.getTexture().getX()-1);
        }else {
            reset();
        }
    }

    void launch(int difficulty){


    }

    private void reset(){
        this.getTexture().setX(1100);
        this.getTexture().setY(Math.random()*720);
    }

    public static int getRockID() {
        return rockID;
    }


}
