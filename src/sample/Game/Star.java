package sample.Game;

import javafx.scene.image.ImageView;

class Star extends SpaceObject {

    static private int starID;

    Star(int x, int y, ImageView texture) {
        super(x, y, texture);
        starID++;
    }


    @Override
    void move() {
        if (this.getTexture().getX() > -100) {
            this.getTexture().setX(this.getTexture().getX() - 1);
        } else {
            reset();
        }

    }

    private void reset() {
        this.getTexture().setX(1080);
    }

    @SuppressWarnings("unused")
    public static int getStarID() {
        return starID;
    }

}
