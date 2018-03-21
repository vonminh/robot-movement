package com.tma.solutions.robot;

import com.tma.solutions.commands.ICommand;
import com.tma.solutions.commands.PlaceCommand;
import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;
import com.tma.solutions.dimension.RelativeDirectionEnum;
import com.tma.solutions.dimension.SurfaceTable;
import com.tma.solutions.input.CommandParser;
import com.tma.solutions.utils.RobotUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

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
        return this.coordinates.getxVal() + " " + this.coordinates.getyVal() + " " + direction.getDescription();
    }

    //TODO: get the first PLACECOMMAND TO RUN then check valid or not
    public void run(List<String> commands) {
        CommandParser parser = new CommandParser();
        List<ICommand> executionCommands =  parser.parse(commands);

        Predicate isPlaceCommand = PlaceCommand.class::isInstance;

        boolean hasAPlaceCommand = executionCommands.stream().anyMatch(isPlaceCommand);

        if (hasAPlaceCommand) {
            AtomicInteger position = new AtomicInteger();

            executionCommands.stream()
                    .peek(x -> position.incrementAndGet())
                    .filter(isPlaceCommand)
                    .findFirst()
                    .get();

            if (position.decrementAndGet() != 0) {
                executionCommands = executionCommands.subList(position.get(), executionCommands.size());
            }

            for (ICommand command : executionCommands) {
                command.execute(this);
            }

        } else {
            System.out.println("No Place command has been found");
        }
    }
}
