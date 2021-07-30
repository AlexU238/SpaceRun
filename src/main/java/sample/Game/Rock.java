package sample.Game;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


class Rock extends SpaceObject {

    private Circle hitbox = new Circle();

    Rock(int x, int y, ImageView texture) {
        super(x, y, texture);
        hitbox.setCenterY(y + 20);
        hitbox.setCenterX(x + 20);
        hitbox.setRadius(20);
        hitbox.setFill(Color.TRANSPARENT);
        this.getTexture().setFitHeight(40);
        this.getTexture().setFitWidth(40);
    }


    @Override
    void move() {
        if (this.getTexture().getX() > -100) {
            this.getTexture().setX(this.getTexture().getX() - 1);
            this.getHitbox().setCenterX(this.getHitbox().getCenterX() - 1);
        } else {
            reset();
        }
    }


    private void reset() {
        this.getTexture().setX(1100);
        this.getTexture().setY(Math.random() * 720);
        this.getHitbox().setCenterX(this.getTexture().getX() + 20);
        this.getHitbox().setCenterY(this.getTexture().getY() + 20);
    }


    Circle getHitbox() {
        return hitbox;
    }

}
