package sample.Game;

import java.util.*;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static javafx.application.Platform.exit;


public final class Space {

    private LinkedList<Star> starLinkedList;
    private LinkedList<Rock> rockLinkedList;
    private SpaceShip player;
    private float difficulty;
    private Rectangle background;
    private static final int NUMBER_OF_ROCKS = 10;//initially it was 20, but it was unreal to beat, so it was changed to 10
    private static final int NUMBER_OF_STARS = 11;

    private Space() {
        this.starLinkedList = new LinkedList<>();
        this.rockLinkedList = new LinkedList<>();
        this.background = new Rectangle();
        this.background.setY(0);
        this.background.setX(-100);
        this.background.setWidth(1180);
        this.background.setHeight(720);
        this.background.setFill(Color.BLACK);
        TextureLoader.loadMainThreeTextures();
    }

    public static Space connectToSpace() {
        return new Space();
    }

    private Group generateStars() {
        Group stars = new Group();
        int x = 0;
        int y = 0;
        for (int i = 0; i <= NUMBER_OF_STARS; i++) {
            starLinkedList.add(new Star(x, y, new ImageView(TextureLoader.getStar())));
            x += 100;
        }
        for (Star s : starLinkedList) {
            stars.getChildren().add(s.getTexture());
        }
        return stars;
    }

    private Group generateRocks() {
        Group rocks = new Group();
        Random rnd = new Random();
        int x = 1140;
        for (int i = 0; i <= NUMBER_OF_ROCKS; i++) {
            rockLinkedList.add(new Rock(x, rnd.nextInt(720), new ImageView(TextureLoader.getRock())));
        }
        for (Rock r : rockLinkedList) {
            rocks.getChildren().addAll(r.getHitbox(), r.getTexture());
        }
        return rocks;
    }

    private Group spawnShip() { // try to make a better version
        Group ship = new Group();
        player = new SpaceShip(0, 0, new ImageView(TextureLoader.getShip()));
        ship.getChildren().addAll(player.getTriangleHitbox(),player.getTexture());
        return ship;
    }


    public EventHandler<KeyEvent> startShip() {
        return player.giveAccessToShipControls();
    }

    public void adjustDifficulty() {
        difficulty += 0.0015;
        if ((int) difficulty >= NUMBER_OF_ROCKS + 1) {
            difficulty = NUMBER_OF_ROCKS + 1;
        }
    }

    public void moveBackGround() {
        for (Star s : starLinkedList) {
            s.move();
        }
    }

    public void moveRocks() {
        for (int i = 0; i <= difficulty - 1; i++) {
            launchRocks(i);
        }
    }

    private void launchRocks(int starter) {
        for (int i = 0; i <= starter; i++) {
            rockLinkedList.get(i).move();
        }
    }

    public void collide(){//add UI exit here
        for(Rock r:rockLinkedList){
            if (r.getHitbox().contains(player.getTriangleHitbox().getPoints().get(0),player.getTriangleHitbox().getPoints().get(1))){
                exit();
            }
            if (r.getHitbox().contains(player.getTriangleHitbox().getPoints().get(2),player.getTriangleHitbox().getPoints().get(3))){
                System.out.println("GG");
            }
            if (r.getHitbox().contains(player.getTriangleHitbox().getPoints().get(4),player.getTriangleHitbox().getPoints().get(5))){
                System.out.println("GG");
            }
        }

    }

    public Group getStars() {
        return generateStars();
    }

    public Group getRocks() {
        return generateRocks();
    }

    public Group getShip() {
        return spawnShip();
    }

    public float getDifficulty() {
        return difficulty;
    }

    public Rectangle getBackground() {
        return background;
    }


}

