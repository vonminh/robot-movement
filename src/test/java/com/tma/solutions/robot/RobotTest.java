package com.tma.solutions.robot;

import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;
import com.tma.solutions.dimension.SurfaceTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link Robot}.
 */
public class RobotTest {

    private Robot testRobot;

    /**
     * Sets up before run a single test.
     */
    @Before
    public void setUp() {

        SurfaceTable surfaceTable = new SurfaceTable(5, 5);
        Coordinate2D initialPosition = new Coordinate2D(2, 2);
        CardinalDirectionEnum initialDirection = CardinalDirectionEnum.N;

        testRobot = new Robot(surfaceTable);
        testRobot.place(initialPosition, initialDirection);
    }

    /**
     * Tests {@link Robot#place(Coordinate2D, CardinalDirectionEnum)}.
     */
    @Test
    public void testRobotCannotBePlaceOutOfTable() {
        Coordinate2D oldCoordinates = testRobot.getCoordinates();
        Coordinate2D newPosition = new Coordinate2D(6, -1);
        CardinalDirectionEnum newDirection = CardinalDirectionEnum.E;
        testRobot.place(newPosition, newDirection);
        assertEquals(testRobot.getCoordinates(), oldCoordinates);
    }

    /**
     * Tests {@link Robot#spinLeft()}.
     */
    @Test
    public void testIfRobotCanSpinLeft() {
        testRobot.spinLeft();
        assertEquals(CardinalDirectionEnum.W, testRobot.getDirection());
    }

    /**
     * Tests {@link Robot#spinRight()}.
     */
    @Test
    public void testIfRobotCanSpinRight() {
        testRobot.spinRight();
        assertEquals(CardinalDirectionEnum.E, testRobot.getDirection());
    }

    /**
     * Tests {@link Robot#move(int)}.
     */
    @Test
    public void testIfRobotMovable() {
        testRobot.move(2);
        assertEquals(2, testRobot.getCoordinates().getxVal());
        assertEquals(4, testRobot.getCoordinates().getyVal());
    }

    /**
     * Tests {@link Robot#move(int)}.
     */
    @Test
    public void testRobotCannotMoveOutOfTable() {
        testRobot.move(4);
        assertEquals(2, testRobot.getCoordinates().getxVal());
        assertEquals(2, testRobot.getCoordinates().getyVal());
    }

    /**
     * Tests {@link Robot#currentLocation()}.
     */
    @Test
    public void testCurrentLocation() {
        String report = testRobot.currentLocation();
        String expected = "2 2 NORTH";
        assertEquals(expected, report);
    }
}