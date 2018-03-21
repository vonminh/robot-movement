package com.tma.solutions.commands;

import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;
import com.tma.solutions.robot.Robot;

public class PlaceCommand implements ICommand {

    private Coordinate2D coordinate;
    private CardinalDirectionEnum direction;

    public PlaceCommand(Coordinate2D coordinate, CardinalDirectionEnum direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public void execute(Robot robot) {
        robot.place(this.coordinate, this.direction);
    }
}
