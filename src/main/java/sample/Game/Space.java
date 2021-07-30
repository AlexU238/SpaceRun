package sample.Game;

import java.util.*;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

final class Space {

    private LinkedList<Star> starLinkedList;
    private LinkedList<Rock> rockLinkedList;
    private SpaceShip player;
    private double difficulty;
    private static final int NUMBER_OF_ROCKS = 10;//initially it was 20, but it was unreal to beat, so it was changed to 10
    private static final int NUMBER_OF_STARS = 11;
    private static final double DIFFICULTY_INCREASE = 0.0015;
    private double score = 0;


    private Space() {
        this.starLinkedList = new LinkedList<>();
        this.rockLinkedList = new LinkedList<>();
        GameTextureLoader.loadGameTextures();

    }

    static Space connectToSpace() {
        return new Space();
    }

    private Group generateStars() {
        Group stars = new Group();
        int x = 0;
        for (int i = 0; i <= NUMBER_OF_STARS; i++) {
            starLinkedList.add(new Star(x, 0, new ImageView(GameTextureLoader.getStar())));
            x += 100;
        }
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
        rockLinkedList.forEach((rock -> rocks.getChildren().addAll(rock.getHitbox(), rock.getTexture())));
        return rocks;
    }

    private Group spawnShip() { // try to make a better version
        Group ship = new Group();
        player = new SpaceShip(0, 0, new ImageView(GameTextureLoader.getShip()));
        ship.getChildren().addAll(player.getTriangleHitbox(), player.getTexture(), player.getExplosion());
        return ship;
    }

    void moveShipAdditionalTexture() {
        player.move();
    }

    void adjustDifficulty() {
        setDifficulty(getDifficulty() + DIFFICULTY_INCREASE);
        if (getDifficulty() >= 1) {
            countScore();
        }
        if ((int) getDifficulty() >= NUMBER_OF_ROCKS + 1) {
            difficulty = NUMBER_OF_ROCKS + 1;
        }
    }

    void moveBackGround() {
        starLinkedList.forEach((Star::move));
    }

    void moveRocks() {
        for (int i = 0; i <= getDifficulty() - 1; i++) {
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

    String printScore() {
        return "Score: " + getScore();
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


    Group getStarsGroup() {
        return generateStars();
    }

    Group getRocksGroup() {
        return generateRocks();
    }

    Group getShipGroup() {
        return spawnShip();
    }

    EventHandler<KeyEvent> getShipControls() {
        return player.giveAccessToShipControls();
    }

    int getScore() {
        return (int) score;
    }

    double getDifficulty() {
        return difficulty;
    }

    private void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }
}

