package com.tma.solutions.utils;

import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;
import com.tma.solutions.dimension.RelativeDirectionEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link RobotUtils}.
 */
public class RobotUtilsTest {

    /**
     * Tests {@link RobotUtils#rotate(CardinalDirectionEnum, RelativeDirectionEnum)}.
     */
    @Test
    public void testRotateLeft() {

        RelativeDirectionEnum left = RelativeDirectionEnum.L;

        assertEquals(CardinalDirectionEnum.W, RobotUtils.rotate(CardinalDirectionEnum.N, left));
        assertEquals(CardinalDirectionEnum.N, RobotUtils.rotate(CardinalDirectionEnum.E, left));
        assertEquals(CardinalDirectionEnum.E, RobotUtils.rotate(CardinalDirectionEnum.S, left));
        assertEquals(CardinalDirectionEnum.S, RobotUtils.rotate(CardinalDirectionEnum.W, left));
    }

    /**
     * Tests {@link RobotUtils#rotate(CardinalDirectionEnum, RelativeDirectionEnum)}.
     */
    @Test
    public void testRotateRight() {

        RelativeDirectionEnum right = RelativeDirectionEnum.R;

        assertEquals(CardinalDirectionEnum.E, RobotUtils.rotate(CardinalDirectionEnum.N, right));
        assertEquals(CardinalDirectionEnum.S, RobotUtils.rotate(CardinalDirectionEnum.E, right));
        assertEquals(CardinalDirectionEnum.W, RobotUtils.rotate(CardinalDirectionEnum.S, right));
        assertEquals(CardinalDirectionEnum.N, RobotUtils.rotate(CardinalDirectionEnum.W, right));
    }

    /**
     * Tests {@link RobotUtils#move(Coordinate2D, CardinalDirectionEnum, int)}.
     */
    @Test
    public void moveOneStepToTheNorth() {
        Coordinate2D currentCoordinates = new Coordinate2D(1, 1);
        Coordinate2D newCoordinates = RobotUtils.move(currentCoordinates, CardinalDirectionEnum.N, 1);
        assertEquals(1, newCoordinates.getxVal());
        assertEquals(2, newCoordinates.getyVal());
    }

    /**
     * Tests {@link RobotUtils#move(Coordinate2D, CardinalDirectionEnum, int)}.
     */
    @Test
    public void moveOneStepToTheEast() {
        Coordinate2D currentCoordinates = new Coordinate2D(1, 1);
        Coordinate2D newCoordinates = RobotUtils.move(currentCoordinates, CardinalDirectionEnum.E, 1);
        assertEquals(2, newCoordinates.getxVal());
        assertEquals(1, newCoordinates.getyVal());
    }

    /**
     * Tests {@link RobotUtils#move(Coordinate2D, CardinalDirectionEnum, int)}.
     */
    @Test
    public void moveOneStepToTheSouth() {
        Coordinate2D currentCoordinates = new Coordinate2D(1, 1);
        Coordinate2D newCoordinates = RobotUtils.move(currentCoordinates, CardinalDirectionEnum.S, 1);
        assertEquals(1, newCoordinates.getxVal());
        assertEquals(0, newCoordinates.getyVal());
    }

    /**
     * Tests {@link RobotUtils#move(Coordinate2D, CardinalDirectionEnum, int)}.
     */
    @Test
    public void moveOneStepToTheWest() {
        Coordinate2D currentCoordinates = new Coordinate2D(1, 1);
        Coordinate2D newCoordinates = RobotUtils.move(currentCoordinates, CardinalDirectionEnum.W, 1);
        assertEquals(0, newCoordinates.getxVal());
        assertEquals(1, newCoordinates.getyVal());
    }
}