package com.tma.solutions.input;

import com.tma.solutions.commands.ICommand;
import com.tma.solutions.commands.MoveCommand;
import com.tma.solutions.commands.PlaceCommand;
import com.tma.solutions.commands.ReportCommand;
import com.tma.solutions.commands.SpinLeftCommand;
import com.tma.solutions.commands.SpinRightCommand;
import com.tma.solutions.dimension.CardinalDirectionEnum;
import com.tma.solutions.dimension.Coordinate2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandParser {

    private final Map<String, ICommand> COMMAND_MAP = new HashMap<String, ICommand>() {{
        put("LEFT", new SpinLeftCommand());
        put("RIGHT", new SpinRightCommand());
        put("MOVE", new MoveCommand());
        put("REPORT", new ReportCommand());
    }};

    private final String PLACE_COMMAND_INPUT_PATTERN = "^\\d+\\s*,\\s*\\d+\\s*,\\s*(EAST|WEST|NORTH|SOUTH)$";

    public List<ICommand> parse(List<String> commands){
        List<ICommand> parsedCommands = new ArrayList<>();

        for(String command : commands) {
            ICommand mappedCommand = generateCommand(command);
            parsedCommands.add(mappedCommand);
        }

        return parsedCommands;
    }

    private ICommand generateCommand(String command) {


        if (!command.startsWith("PLACE")) {
            return COMMAND_MAP.get(command);
        }

        String argumentString = command.substring("PLACE".length()).trim();

        if (argumentString.matches(PLACE_COMMAND_INPUT_PATTERN)) {

            String arguments[] = Arrays.stream(argumentString.split(",")).map(String::trim).toArray(String[]::new);
            Coordinate2D coordinate = new Coordinate2D(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
            CardinalDirectionEnum direction = CardinalDirectionEnum.fromDescription(arguments[2]);
            return new PlaceCommand(coordinate, direction);

        }

        return null;
    }
}
