package sample.Game;

import javafx.scene.image.ImageView;

import java.util.Objects;

abstract class SpaceObject {

    private int x;
    private int y;
    private ImageView texture;

    SpaceObject(int x, int y, ImageView texture) {
        this.x = x;
        this.y = y;
        this.texture = texture;
        texture.setX(x);
        texture.setY(y);
    }

    abstract void move();

    private int getX() {
        return x;
    }

    @SuppressWarnings("unused")
    void setX(int x) {
        this.x = x;
    }

    private int getY() {
        return y;
    }

    @SuppressWarnings("unused")
    void setY(int y) {
        this.y = y;
    }

    ImageView getTexture() {
        return texture;
    }

    public void setTexture(ImageView texture) {
        this.texture = texture;
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
