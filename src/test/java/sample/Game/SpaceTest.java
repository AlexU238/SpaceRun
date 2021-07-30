package sample.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static sample.Game.Space.connectToSpace;

class SpaceTest {

    private Space testSpace;

    @Test
    void connectToSpaceTest() {
        assertEquals("sample.Game.Space", connectToSpace().getClass().getName(), "Method should return an instance of Space class");
    }

    @BeforeEach
    void setUp() {
        testSpace = connectToSpace();
    }

    @Test
    void adjustDifficultyTest_DifficultyRise() {
        testSpace.adjustDifficulty();
        assertEquals(0.0015, Math.round(testSpace.getDifficulty() * 10000.0) / 10000.0, "Wrong difficulty calculation");
    }


    @Test
    void countScoreTest_withReflection() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method testCountScore = testSpace.getClass().getDeclaredMethod("countScore");
        testCountScore.setAccessible(true);
        for (int i = 0; i <= 20; i++) {
            testCountScore.invoke(testSpace);
        }
        assertEquals(1, testSpace.getScore(), "Wrong score calculation");
        testCountScore.setAccessible(false);
    }

}