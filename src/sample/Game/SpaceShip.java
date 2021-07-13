package sample.Game;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

class SpaceShip extends SpaceObject implements Ship {
    //private String name;
    private Polygon triangleHitbox = new Polygon();
    private double triangleHitboxTopPointX = 100;
    private double triangleHitboxTopPointY = 331;
    private double triangleHitboxBottomPointX = 100;
    private double triangleHitboxBottomPointY = 390;
    private double triangleHitboxMiddleRightPointX = 150;
    private double triangleHitboxMiddleRightPointY = 361;
    private static double DEFAULT_SPEED_CONSTANT = 10;
    private double speedDirectionUp = DEFAULT_SPEED_CONSTANT;
    private double speedDirectionDown = DEFAULT_SPEED_CONSTANT;

    SpaceShip(int x, int y, ImageView texture) {
        super(x, y, texture);
        //this.name = name;
        this.triangleHitbox.getPoints().addAll(
                triangleHitboxTopPointX, triangleHitboxTopPointY,
                triangleHitboxBottomPointX, triangleHitboxBottomPointY,
                triangleHitboxMiddleRightPointX, triangleHitboxMiddleRightPointY
        );
        this.triangleHitbox.setFill(Color.RED);
        this.getTexture().setX(triangleHitboxTopPointX-30);
        this.getTexture().setY(triangleHitboxTopPointY);
    }


    @Override
    void move() { //I did not know what to do with this method, because I used a different movement mechanic and did not expect that I wont be able to incorporate it in this method. Oops

    }

    private void moveUp() {
        double newTriangleHitboxTopPointY = this.getTriangleHitbox().getPoints().get(1) - speedDirectionUp;
        double newTriangleHitboxBottomPointY = this.getTriangleHitbox().getPoints().get(3) - speedDirectionUp;
        double newTriangleHitboxMiddleRightPointY = this.getTriangleHitbox().getPoints().get(5) - speedDirectionUp;
        this.getTriangleHitbox().getPoints().setAll(
                triangleHitboxTopPointX, newTriangleHitboxTopPointY,
                triangleHitboxBottomPointX, newTriangleHitboxBottomPointY,
                triangleHitboxMiddleRightPointX, newTriangleHitboxMiddleRightPointY
        );
        this.getTexture().setY(this.getTexture().getY() - speedDirectionUp);

        if (this.getTriangleHitbox().getPoints().get(1) == 1) {
            speedDirectionUp = 0;
        } else returnToDefaultSpeed();

    }

    private void moveDown() {
        double newTriangleHitboxTopPointY = this.getTriangleHitbox().getPoints().get(1) + speedDirectionDown;
        double newTriangleHitboxBottomPointY = this.getTriangleHitbox().getPoints().get(3) + speedDirectionDown;
        double newTriangleHitboxMiddleRightPointY = this.getTriangleHitbox().getPoints().get(5) + speedDirectionDown;
        this.getTriangleHitbox().getPoints().setAll(
                getTriangleHitboxTopPointX(), newTriangleHitboxTopPointY,
                getTriangleHitboxBottomPointX(), newTriangleHitboxBottomPointY,
                getTriangleHitboxMiddleRightPointX(), newTriangleHitboxMiddleRightPointY
        );
        this.getTexture().setY(this.getTexture().getY() + speedDirectionDown);

        if (this.getTriangleHitbox().getPoints().get(3) == 720) {
            speedDirectionDown = 0;
        } else returnToDefaultSpeed();
    }

    private void returnToDefaultSpeed() {
        speedDirectionUp = DEFAULT_SPEED_CONSTANT;
        speedDirectionDown = DEFAULT_SPEED_CONSTANT;
    }

    Polygon getTriangleHitbox() {
        return triangleHitbox;
    }

    ShipControls giveAccessToShipControls() {
        return new ShipControls();
    }

    class ShipControls implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent keyEvent) {
            switch (keyEvent.getCode()) {
                case W:
                    moveUp();
                    break;
                case UP:
                    moveUp();
                    break;
                case S:
                    moveDown();
                    break;
                case DOWN:
                    moveDown();
                    break;
            }
        }
    }

    @SuppressWarnings("unused")
    private void setTriangleHitbox(Polygon triangleHitbox) {
        this.triangleHitbox = triangleHitbox;
    }

    private double getTriangleHitboxTopPointX() {
        return triangleHitboxTopPointX;
    }

    @SuppressWarnings("unused")
    private void setTriangleHitboxTopPointX(double triangleHitboxTopPointX) {
        this.triangleHitboxTopPointX = triangleHitboxTopPointX;
    }

    @SuppressWarnings("unused")
    private double getTriangleHitboxTopPointY() {
        return triangleHitboxTopPointY;
    }

    @SuppressWarnings("unused")
    private void setTriangleHitboxTopPointY(double triangleHitboxTopPointY) {
        this.triangleHitboxTopPointY = triangleHitboxTopPointY;
    }

    private double getTriangleHitboxBottomPointX() {
        return triangleHitboxBottomPointX;
    }

    @SuppressWarnings("unused")
    private void setTriangleHitboxBottomPointX(double triangleHitboxBottomPointX) {
        this.triangleHitboxBottomPointX = triangleHitboxBottomPointX;
    }

    @SuppressWarnings("unused")
    private double getTriangleHitboxBottomPointY() {
        return triangleHitboxBottomPointY;
    }

    @SuppressWarnings("unused")
    private void setTriangleHitboxBottomPointY(double triangleHitboxBottomPointY) {
        this.triangleHitboxBottomPointY = triangleHitboxBottomPointY;
    }

    private double getTriangleHitboxMiddleRightPointX() {
        return triangleHitboxMiddleRightPointX;
    }

    @SuppressWarnings("unused")
    private void setTriangleHitboxMiddleRightPointX(double triangleHitboxMiddleRightPointX) {
        this.triangleHitboxMiddleRightPointX = triangleHitboxMiddleRightPointX;
    }

    @SuppressWarnings("unused")
    private double getTriangleHitboxMiddleRightPointY() {
        return triangleHitboxMiddleRightPointY;
    }

    @SuppressWarnings("unused")
    private void setTriangleHitboxMiddleRightPointY(double triangleHitboxMiddleRightPointY) {
        this.triangleHitboxMiddleRightPointY = triangleHitboxMiddleRightPointY;
    }


}
