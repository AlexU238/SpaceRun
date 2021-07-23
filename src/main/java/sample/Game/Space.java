package sample.Game;

import java.util.*;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

final class Space {

    private LinkedList<Star> starLinkedList;
    private LinkedList<Rock> rockLinkedList;
    private SpaceShip player;
    private float difficulty;
    private Rectangle background;
    private static final int NUMBER_OF_ROCKS = 10;//initially it was 20, but it was unreal to beat, so it was changed to 10
    private static final int NUMBER_OF_STARS = 11;
    private double score = 0;


    private Space() {
        this.starLinkedList = new LinkedList<>();
        this.rockLinkedList = new LinkedList<>();
        this.background = new Rectangle();
        this.background.setY(0);
        this.background.setX(-100);
        this.background.setWidth(1180);
        this.background.setHeight(720);
        this.background.setFill(Color.BLACK);
        GameTextureLoader.loadMainThreeTextures();

    }

    static Space connectToSpace() {
        return new Space();
    }

    private Group generateStars() {
        Group stars = new Group();
        int x = 0;
        int y = 0;
        for (int i = 0; i <= NUMBER_OF_STARS; i++) {
            starLinkedList.add(new Star(x, y, new ImageView(GameTextureLoader.getStar())));
            x += 100;
        }

        starLinkedList.forEach(star -> {
            star.getTexture().setFitWidth(102);
            star.getTexture().setFitHeight(722);
        });

        starLinkedList.forEach(star -> stars.getChildren().add(star.getTexture()));
        return stars;
    }

    private Group generateRocks() {
        Group rocks = new Group();
        Random rnd = new Random();
        int x = 1140;
        for (int i = 0; i <= NUMBER_OF_ROCKS; i++) {
            rockLinkedList.add(new Rock(x, rnd.nextInt(720), new ImageView(GameTextureLoader.getRock())));
        }
        rockLinkedList.forEach((rock -> {
            rock.getTexture().setFitHeight(40);
            rock.getTexture().setFitWidth(40);
        }));
        rockLinkedList.forEach((rock -> rocks.getChildren().addAll(rock.getHitbox(), rock.getTexture())));
        return rocks;
    }

    private Group spawnShip() { // try to make a better version
        Group ship = new Group();
        player = new SpaceShip(0, 0, new ImageView(GameTextureLoader.getShip()));
        player.getTexture().setFitHeight(60);
        player.getTexture().setFitWidth(80);
        ship.getChildren().addAll(player.getTriangleHitbox(), player.getTexture(), player.getExplosion());
        return ship;
    }

    void moveShipAdditionalTexture() {
        player.move();
    }

    EventHandler<KeyEvent> startShip() {
        return player.giveAccessToShipControls();
    }

    void adjustDifficulty() {

        difficulty += 0.0015;
        if (difficulty >= 1) {
            countScore();
        }
        if ((int) difficulty >= NUMBER_OF_ROCKS + 1) {
            difficulty = NUMBER_OF_ROCKS + 1;
        }
    }

    void moveBackGround() {
        starLinkedList.forEach((Star::move));
    }

    void moveRocks() {
        for (int i = 0; i <= difficulty - 1; i++) {
            launchRocks(i);
        }
    }

    private void launchRocks(int starter) {
        for (int i = 0; i <= starter; i++) {
            rockLinkedList.get(i).move();
        }
    }

    private void countScore() {
        score = score + 0.05;
    }

    int getScore() {
        return (int) score;
    }

    String printScore() {
        return "Score: " + (int) score;
    }

    boolean collide() {

        for (Rock rock : rockLinkedList) {
            if (rock.getHitbox().contains(player.getTriangleHitbox().getPoints().get(0), player.getTriangleHitbox().getPoints().get(1))) {
                System.out.println("Game Over");
                player.boom();
                return true;
            }
            if (rock.getHitbox().contains(player.getTriangleHitbox().getPoints().get(2), player.getTriangleHitbox().getPoints().get(3))) {
                System.out.println("Game Over");
                player.boom();
                return true;
            }
            if (rock.getHitbox().contains(player.getTriangleHitbox().getPoints().get(4), player.getTriangleHitbox().getPoints().get(5))) {
                System.out.println("Game Over");
                player.boom();
                return true;
            }
        }
        return false;
    }


    Group getStars() {
        return generateStars();
    }

    Group getRocks() {
        return generateRocks();
    }

    Group getShip() {
        return spawnShip();
    }

    @SuppressWarnings("unused")
    float getDifficulty() {
        return difficulty;
    }

    Rectangle getBackground() {
        return background;
    }

}

