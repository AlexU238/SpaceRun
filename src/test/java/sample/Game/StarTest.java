package sample.Game;

import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StarTest {
    private Star testStar;

    @BeforeEach
    void setUp() {
        testStar = new Star(0, 0, new ImageView(GameTextureLoader.getStar()));
    }

    @Test
    void moveSpeedTest() {
        testStar.move();
        assertEquals(-1, testStar.getTexture().getX(), "Movement speed of star texture is not correct. Star speed is equal to 1");
    }

    @Test
    void moveToResetTest() {
        for (int i = 0; i <= 100; i++) {
            testStar.move();
        }
        float xResetCoordinateExpected = 1080;
        assertEquals(xResetCoordinateExpected, testStar.getTexture().getX(), "Reset method coordinates are not correct. Reset X coordinate should be 1080 or the same as the visible screen width.");
    }

    @Test
    void movement_YDirection_Test() {
        testStar.move();
        assertEquals(0, testStar.getTexture().getY(), "Star texture movement direction is incorrect. Star texture cannot move in any Y axis direction.");
    }

    @Test
    void movement_XDirection_Test() {
        testStar.move();
        assertTrue(testStar.getTexture().getX() < 0, "Star texture movement direction is incorrect. Star texture can only move in the negative direction.");
    }
}