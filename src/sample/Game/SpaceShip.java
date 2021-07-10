package sample.Game;

import javafx.scene.image.ImageView;

class SpaceShip extends SpaceObject implements Ship {
    private String name;
    private ShipControls shipControls;
    private int collisionPoint1;
    private int collisionPoint2;
    private int collisionPoint3;

    SpaceShip(int x, int y, String name, ImageView texture) {
        super(x, y, texture);
        this.name = name;
        this.shipControls = new ShipControls();
    }

    @Override
    void move() {

    }

    void crash() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShipControls getShipControls() {
        return shipControls;
    }

    public void setShipControls(ShipControls shipControls) {
        this.shipControls = shipControls;
    }

    public int getCollisionPoint1() {
        return collisionPoint1;
    }

    public void setCollisionPoint1(int collisionPoint1) {
        this.collisionPoint1 = collisionPoint1;
    }

    public int getCollisionPoint2() {
        return collisionPoint2;
    }

    public void setCollisionPoint2(int collisionPoint2) {
        this.collisionPoint2 = collisionPoint2;
    }

    public int getCollisionPoint3() {
        return collisionPoint3;
    }

    public void setCollisionPoint3(int collisionPoint3) {
        this.collisionPoint3 = collisionPoint3;
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "name='" + name + '\'' +
                ", shipControls=" + shipControls +
                ", collisionPoint1=" + collisionPoint1 +
                ", collisionPoint2=" + collisionPoint2 +
                ", collisionPoint3=" + collisionPoint3 +
                '}';
    }
}
