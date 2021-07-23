package sample.Game;

import javafx.scene.image.ImageView;

class Star extends SpaceObject {


    Star(int x, int y, ImageView texture) {
        super(x, y, texture);
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

}
