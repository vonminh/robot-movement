package com.tma.solutions.robot;

import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;
import com.tma.solutions.dimension.RelativeDirectionEnum;
import com.tma.solutions.dimension.SurfaceTable;
import com.tma.solutions.utils.RobotUtils;

public class Robot {

    private Coordinate2D coordinates;
    private CardinalDirectionEnum direction;
    private SurfaceTable surfaceTable;

    public Robot(SurfaceTable surfaceTable) {
        this.surfaceTable = surfaceTable;
    }

    public void place(Coordinate2D newCoordinates, CardinalDirectionEnum newDirection) {
        if(surfaceTable.hasWithinBoundary(newCoordinates)){
            this.coordinates = newCoordinates;
            this.direction = newDirection;
        }
    }

    public void spinRight() {
        this.direction = RobotUtils.rotate(this.direction, RelativeDirectionEnum.R);
    }

    public void spinLeft() {
        this.direction = RobotUtils.rotate(this.direction, RelativeDirectionEnum.L);
    }

    public void move(int stepNumber) {
        Coordinate2D updatedPosition = RobotUtils.move(this.coordinates, this.direction, stepNumber);
        if(surfaceTable.hasWithinBoundary(updatedPosition))
            this.coordinates = updatedPosition;
    }

    public String currentLocation() {
        return this.coordinates.getxVal() + " "
                + this.coordinates.getyVal() + " "
                + direction.getDescription();
    }
}
