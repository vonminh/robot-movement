package com.tma.solutions.services;

import com.tma.solutions.commands.ICommand;
import com.tma.solutions.commands.PlaceCommand;
import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;
import com.tma.solutions.input.CommandParser;
import com.tma.solutions.robot.Robot;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Use the process specific robot with specific commands.
 *
 * @author vnminh
 */
public class RobotProcessor {

    /**
     * Process the robot.
     *
     * @param robot the robot.
     * @param commandStringList list of commands in string.
     */
    public void process(Robot robot, List<String> commandStringList) {

        CommandParser parser = new CommandParser();
        List<ICommand> executionCommands = parser.parse(commandStringList);

        int firstValidPlaceCommand = findIndexOfFirstValidPlaceCommand(robot, executionCommands);

        if (firstValidPlaceCommand == -1) {
            System.out.println("Oops! I am still not on the table yet.");
            return;
        }

        if (firstValidPlaceCommand > 0) {
            executionCommands = executionCommands.subList(firstValidPlaceCommand, executionCommands.size());
        }

        for (ICommand command : executionCommands) {
            command.execute(robot);
        }
    }

    /**
     * Methods to find the index of first valid place command in command list.
     *
     * @param robot the robot.
     * @param executionCommands list of commands in string.
     * @return index of the first valid place command in the list.
     */
    private int findIndexOfFirstValidPlaceCommand(Robot robot, List<ICommand> executionCommands) {

        Predicate isPlaceCommand = PlaceCommand.class::isInstance;

        while (executionCommands.stream().anyMatch(isPlaceCommand)) {

            AtomicInteger position = new AtomicInteger();

            ICommand placeCommand = (PlaceCommand) executionCommands.stream()
                    .peek(x -> position.incrementAndGet())
                    .filter(isPlaceCommand)
                    .findFirst()
                    .get();

            Coordinate2D oldCoordinates = robot.getCoordinates();
            CardinalDirectionEnum oldDirection = robot.getDirection();

            placeCommand.execute(robot);

            Coordinate2D updatedCoordinates = robot.getCoordinates();
            CardinalDirectionEnum updatedDirection = robot.getDirection();

            if (updatedCoordinates != null && !updatedCoordinates.equals(oldCoordinates) && updatedDirection != oldDirection) {
                return position.get();
            } else {
                executionCommands = executionCommands.subList(position.get(), executionCommands.size());
                continue;
            }
        }

        return -1;
    }
}
