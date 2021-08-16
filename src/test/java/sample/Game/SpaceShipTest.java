package sample.Game;

import javafx.scene.image.ImageView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class SpaceShipTest {
    private SpaceShip testSpaceShip;

    @BeforeEach
    void setUp() {
        testSpaceShip = new SpaceShip(0, 0, new ImageView(GameTextureLoader.loadGameShipTexture()));
    }

    @Test
    void move_ExplosionTextureX_test() {
        testSpaceShip.moveExplosionTexture();
        assertEquals(testSpaceShip.getTexture().getX(), testSpaceShip.getExplosion().getX());
    }

    @Test
    void move_ExplosionTextureY_test() {
        testSpaceShip.moveExplosionTexture();
        assertEquals(testSpaceShip.getTexture().getY(), testSpaceShip.getExplosion().getY());
    }

    @Test
    void giveAccessToShipControls() {
        assertEquals("sample.Game.SpaceShip$ShipControls", testSpaceShip.giveAccessToShipControls().getClass().getName());
    }

    @Test
    void moveUpTest_Texture_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testMoveUp = testSpaceShip.getClass().getDeclaredMethod("moveUp");
        testMoveUp.setAccessible(true);
        testMoveUp.invoke(testSpaceShip);
        assertEquals(321, testSpaceShip.getTexture().getY());
        testMoveUp.setAccessible(false);
    }

    @Test
    void moveUpTest_TriangleHitboxTopPointY_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testMoveUp = testSpaceShip.getClass().getDeclaredMethod("moveUp");
        testMoveUp.setAccessible(true);
        testMoveUp.invoke(testSpaceShip);
        assertEquals(321, testSpaceShip.getTriangleHitbox().getPoints().get(1));
        testMoveUp.setAccessible(false);
    }

    @Test
    void moveUpTest_TriangleHitboxBottomPointY_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testMoveUp = testSpaceShip.getClass().getDeclaredMethod("moveUp");
        testMoveUp.setAccessible(true);
        testMoveUp.invoke(testSpaceShip);
        assertEquals(380, testSpaceShip.getTriangleHitbox().getPoints().get(3));
        testMoveUp.setAccessible(false);
    }

    @Test
    void moveUpTest_TriangleHitboxMiddleRightPointY_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testMoveUp = testSpaceShip.getClass().getDeclaredMethod("moveUp");
        testMoveUp.setAccessible(true);
        testMoveUp.invoke(testSpaceShip);
        assertEquals(351, testSpaceShip.getTriangleHitbox().getPoints().get(5));
        testMoveUp.setAccessible(false);
    }

    @Test
    void moveDownTest_Texture_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testMoveUp = testSpaceShip.getClass().getDeclaredMethod("moveDown");
        testMoveUp.setAccessible(true);
        testMoveUp.invoke(testSpaceShip);
        assertEquals(341, testSpaceShip.getTexture().getY());
        testMoveUp.setAccessible(false);
    }

    @Test
    void moveDownTest_TriangleHitboxTopPointY_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testMoveDown = testSpaceShip.getClass().getDeclaredMethod("moveDown");
        testMoveDown.setAccessible(true);
        testMoveDown.invoke(testSpaceShip);
        assertEquals(341, testSpaceShip.getTriangleHitbox().getPoints().get(1));
        testMoveDown.setAccessible(false);
    }

    @Test
    void moveDownTest_TriangleHitboxBottomPointY_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testMoveDown = testSpaceShip.getClass().getDeclaredMethod("moveDown");
        testMoveDown.setAccessible(true);
        testMoveDown.invoke(testSpaceShip);
        assertEquals(400, testSpaceShip.getTriangleHitbox().getPoints().get(3));
        testMoveDown.setAccessible(false);
    }

    @Test
    void moveDownTest_TriangleHitboxMiddleRightPointY_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method testMoveDown = testSpaceShip.getClass().getDeclaredMethod("moveDown");
        testMoveDown.setAccessible(true);
        testMoveDown.invoke(testSpaceShip);
        assertEquals(371, testSpaceShip.getTriangleHitbox().getPoints().get(5));
        testMoveDown.setAccessible(false);
    }

    @Test
    void boomTest() {
        testSpaceShip.boom();
        assertTrue(testSpaceShip.getExplosion().isVisible());
    }


}