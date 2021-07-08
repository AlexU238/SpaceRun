package sample.Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.text.Position;
import java.util.Objects;

abstract class SpaceObject {

    private int x;
    private int y;
    private ImageView texture;

    SpaceObject(int x, int y, ImageView texture) {
        this.x = x;
        this.y = y;
        this.texture=texture;
        texture.setX(x);
        texture.setY(y);
    }

    abstract void move();

    int getX() {
        return x;
    }

     void setX(int x) {
        this.x = x;
    }

     public int getY() {
        return y;
    }

     void setY(int y) {
        this.y = y;
    }

    public ImageView getTexture() {
        return texture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpaceObject)) return false;
        SpaceObject that = (SpaceObject) o;
        return getX() == that.getX() &&
                getY() == that.getY() &&
                texture.equals(that.texture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), texture);
    }
}
