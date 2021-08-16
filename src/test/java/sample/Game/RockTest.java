package sample.Game;

import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RockTest {

    private Rock testRock;
    private Random rnd = new Random();

    @BeforeEach
    void setUp() {
        testRock = new Rock(1140, rnd.nextInt(720), new ImageView(GameTextureLoader.loadGameRockTexture()));
        assertTrue(testRock.getTexture().getY() >= 0 && testRock.getTexture().getY() <= 720, "Rock texture Y coordinates are out of bounds"); //not a good test, but I have no idea how to test randomness
    }

    @Test
    void moveSpeed_TextureXCoordinate_Test() {
        testRock.move(-1);
        assertEquals(1139, testRock.getTexture().getX(), "Rock texture movement speed is not correct. Should be: 1");
    }

    @Test
    void moveSpeed_HitboxXCoordinate_Test() {
        testRock.move(-1);
        assertEquals(1159, testRock.getHitbox().getCenterX(), "Rock hitbox movement speed is not correct. Should be: 1");
    }

    @Test
    void moveReset_TextureXCoordinate_Test() {
        for (int i = 0; i <= 1240; i++) {
            testRock.move(-1);
        }
        float xResetCoordinateExpected = 1100;
        assertEquals(xResetCoordinateExpected, testRock.getTexture().getX(), "Reset method coordinates are not correct. Reset X coordinate should be 1100 or at least 20 pixels after the end of the visible screen width");
    }

    @Test
    void moveReset_TextureYCoordinate_Test() {
        for (int i = 0; i <= 1240; i++) {
            testRock.move(-1);
        }
        assertTrue(testRock.getTexture().getY() >= 0 && testRock.getTexture().getY() <= 720, "Reset Rock texture Y coordinates are out of bounds");
    }

    @Test
    void moveReset_HitboxXCoordinate_Test() {
        for (int i = 0; i <= 1240; i++) {
            testRock.move(-1);
        }
        float xResetCoordinateExpected = 1100;
        assertEquals(xResetCoordinateExpected + 20, testRock.getHitbox().getCenterX(), "Reset hitbox X coordinate is not correct. It should be +20 from Rock texture X coordinate");
    }

    @Test
    void moveReset_HitboxYCoordinate_Test() {
        for (int i = 0; i <= 1240; i++) {
            testRock.move(-1);
        }
        assertEquals(testRock.getTexture().getY() + 20, testRock.getHitbox().getCenterY(), "Reset hitbox Y coordinate is not correct. It should be +20 from Rock texture Y coordinate");
    }

    @Test
    void move_TextureXDirection_Test() {
        double xCoordinateExpected = testRock.getTexture().getX();
        testRock.move(-1);
        assertTrue(testRock.getTexture().getX() < xCoordinateExpected, "X direction is wrong. Rocks move from right to left");
    }

    @Test
    void move_TextureYDirection_Test() {
        double yCoordinateExpected = testRock.getTexture().getY();
        testRock.move(-1);
        assertEquals(yCoordinateExpected, testRock.getTexture().getY(), "Y direction is wrong. Rocks cannot move along Y axis");
    }

    @Test
    void move_HitboxXDirection_Test() {
        double xCoordinateExpected = testRock.getHitbox().getCenterX();
        testRock.move(-1);
        assertTrue(testRock.getHitbox().getCenterX() < xCoordinateExpected, "X direction is wrong. Rocks move from right to left");
    }

    @Test
    void move_HitboxYDirection_Test() {
        double yCoordinateExpected = testRock.getHitbox().getCenterY();
        testRock.move(-1);
        assertEquals(yCoordinateExpected, testRock.getHitbox().getCenterY(), "Y direction is wrong. Rocks cannot move along Y axis");
    }

}