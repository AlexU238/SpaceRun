package sample.Game;

import javafx.scene.image.ImageView;

abstract class SpaceObject {

    private ImageView texture;

    SpaceObject(int x, int y, ImageView texture) {
        this.texture = texture;
        texture.setX(x);
        texture.setY(y);
    }

    abstract void move();

    ImageView getTexture() {
        return texture;
    }

    @SuppressWarnings("unused")
    public void setTexture(ImageView texture) {
        this.texture = texture;
    }


}
