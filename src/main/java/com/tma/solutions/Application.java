package com.tma.solutions;

import com.tma.solutions.commands.*;
import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;
import com.tma.solutions.dimension.SurfaceTable;
import com.tma.solutions.robot.Robot;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/**
 * Main class which will trigger the application.
 *
 * @author vnminh
 */
public class Application {

    public static void main(String[] args) {

        SurfaceTable surfaceTable = new SurfaceTable(5, 5);
        Robot robot = new Robot(surfaceTable);

        List<ICommand> commands = Arrays.asList(
                new MoveCommand(),
                new MoveCommand(),
                new PlaceCommand(new Coordinate2D(3, 2), CardinalDirectionEnum.E),
                new SpinRightCommand(),
                new MoveCommand(),
                new SpinLeftCommand(),
                new MoveCommand(),
                new ReportCommand()
        );

        Predicate isPlaceCommand = PlaceCommand.class::isInstance;

        boolean hasAPlaceCommand = commands.stream().anyMatch(isPlaceCommand);

        if (hasAPlaceCommand) {
            AtomicInteger position = new AtomicInteger();
            commands.stream()
                    .peek(x -> position.incrementAndGet())
                    .filter(isPlaceCommand)
                    .findFirst()
                    .get();

            List<ICommand> checkedCommands = null;
            if (position.decrementAndGet() != 0) {
                checkedCommands = commands.subList(position.get(), commands.size());
            }
            for (ICommand command : checkedCommands) {
                command.execute(robot);
            }
        } else {
            System.out.println("No Place command has been found");
        }
    }
}
