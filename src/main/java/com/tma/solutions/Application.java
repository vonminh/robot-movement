package com.tma.solutions;

import com.tma.solutions.commands.ICommand;
import com.tma.solutions.commands.MoveCommand;
import com.tma.solutions.commands.SpinLeftCommand;
import com.tma.solutions.commands.SpinRightCommand;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Main class which will trigger the application.
 *
 * @author vnminh
 */
public class Application {

    public static void main(String[] args) throws IOException {

//        SurfaceTable surfaceTable = new SurfaceTable(5, 5);
//        Robot robot = new Robot(surfaceTable);
//
//        List<ICommand> commands = Arrays.asList(
//                new MoveCommand(),
//                new MoveCommand(),
//                new PlaceCommand(new Coordinate2D(3, 2), CardinalDirectionEnum.E),
//                new SpinRightCommand(),
//                new MoveCommand(),
//                new SpinLeftCommand(),
//                new MoveCommand(),
//                new ReportCommand()
//        );
//
//        Predicate isPlaceCommand = PlaceCommand.class::isInstance;
//
//        boolean hasAPlaceCommand = commands.stream().anyMatch(isPlaceCommand);
//
//        if (hasAPlaceCommand) {
//            AtomicInteger position = new AtomicInteger();
//            commands.stream()
//                    .peek(x -> position.incrementAndGet())
//                    .filter(isPlaceCommand)
//                    .findFirst()
//                    .get();
//
//            List<ICommand> checkedCommands = null;
//            if (position.decrementAndGet() != 0) {
//                checkedCommands = commands.subList(position.get(), commands.size());
//            }
//            for (ICommand command : checkedCommands) {
//                command.execute(robot);
//            }
//        } else {
//            System.out.println("No Place command has been found");
//        }

        String filePath = "D:\\IOOF\\commands.txt";

        List<String> inputFromFile = collectInputFromFile(filePath);
        inputFromFile.forEach(System.out::println);

    }

    public static List<String> collectInputFromFile(String filePath) throws IOException {

        List<String> inputs;

        try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
            inputs = stream
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());
        }

        return inputs;
    }

    private static final Map<String, ICommand> STRING_TO_COMMAND_MAP = new HashMap<String, ICommand>() {{
        put("LEFT", new SpinLeftCommand());
        put("RIGHT", new SpinRightCommand());
        put("MOVE", new MoveCommand());
        put("REPORT", new MoveCommand());

    }};
}
