package com.tma.solutions.utils;

import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;
import com.tma.solutions.dimension.RelativeDirectionEnum;

/**
 * Utility class for Robot movements.
 *
 * @author vnminh
 */
public final class RobotUtils {

    /**
     * Cannot instantiate.
     */
    private RobotUtils() {

    }

    /**
     * Rotates the robot base on the cardinal direction and its relative direction.
     *
     * @param currentDirection
     * @param relativeDirection
     * @return position after being rotated.
     */
    public static CardinalDirectionEnum rotate(CardinalDirectionEnum currentDirection, RelativeDirectionEnum relativeDirection) {

        boolean isTurningRight = relativeDirection == RelativeDirectionEnum.R;

        switch (currentDirection) {
            case N:
                return isTurningRight ? CardinalDirectionEnum.E : CardinalDirectionEnum.W;
            case E:
                return isTurningRight ? CardinalDirectionEnum.S : CardinalDirectionEnum.N;
            case S:
                return isTurningRight ? CardinalDirectionEnum.W : CardinalDirectionEnum.E;
            case W:
                return isTurningRight ? CardinalDirectionEnum.N : CardinalDirectionEnum.S;
        }

        return null;
    }

    /**
     * Move the robot.
     *
     * @param currentCoordinates current coordinates.
     * @param direction current direction.
     * @param stepNumber step number.
     * @return the updated coordinates.
     */
    public static Coordinate2D move(Coordinate2D currentCoordinates, CardinalDirectionEnum direction, int stepNumber){

        Coordinate2D updatedPosition = new Coordinate2D(currentCoordinates.getxVal(), currentCoordinates.getyVal());

        switch(direction){
            case N:
                updatedPosition.setyVal(updatedPosition.getyVal() + stepNumber);
                break;
            case E:
                updatedPosition.setxVal(updatedPosition.getxVal() + stepNumber);
                break;
            case S:
                updatedPosition.setyVal(updatedPosition.getyVal() - stepNumber);
                break;
            case W:
                updatedPosition.setxVal(updatedPosition.getxVal() - stepNumber);
                break;
        }

        return updatedPosition;
    }
}