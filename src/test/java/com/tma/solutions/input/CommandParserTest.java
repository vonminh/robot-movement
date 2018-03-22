package com.tma.solutions.input;

import com.tma.solutions.commands.ICommand;
import com.tma.solutions.commands.MoveCommand;
import com.tma.solutions.commands.PlaceCommand;
import com.tma.solutions.commands.ReportCommand;
import com.tma.solutions.commands.SpinLeftCommand;
import com.tma.solutions.commands.SpinRightCommand;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests {@link CommandParser}.
 *
 * @author vnminh
 */
public class CommandParserTest {

    private CommandParser commandParser;
    private List<String> commands;

    /**
     * Sets up before run a single test.
     */
    @Before
    public void setUp() {
        commandParser = new CommandParser();
        commands = new ArrayList<>();
    }

    /**
     * Tests {@link CommandParser#parse(List)}.
     */
    @Test
    public void testParseStringLEFTToSpinLeftCommand() {

        commands.add("LEFT");
        List<ICommand> parsedCommand = commandParser.parse(commands);

        assertTrue(parsedCommand.get(0) instanceof SpinLeftCommand);
        assertEquals(1, parsedCommand.size());
    }

    /**
     * Tests {@link CommandParser#parse(List)}.
     */
    @Test
    public void testParseStringRIGHTToSpinRightCommand() {

        commands.add("RIGHT");
        List<ICommand> parsedCommand = commandParser.parse(commands);

        assertTrue(parsedCommand.get(0) instanceof SpinRightCommand);
        assertEquals(1, parsedCommand.size());
    }

    /**
     * Tests {@link CommandParser#parse(List)}.
     */
    @Test
    public void testParseStringMOVEToMoveCommand() {

        commands.add("MOVE");
        List<ICommand> parsedCommand = commandParser.parse(commands);

        assertTrue(parsedCommand.get(0) instanceof MoveCommand);
        assertEquals(1, parsedCommand.size());
    }

    /**
     * Tests {@link CommandParser#parse(List)}.
     */
    @Test
    public void testParseStringREPORTToReportCommand() {

        commands.add("REPORT");
        List<ICommand> parsedCommand = commandParser.parse(commands);

        assertTrue(parsedCommand.get(0) instanceof ReportCommand);
        assertEquals(1, parsedCommand.size());
    }

    /**
     * Tests {@link CommandParser#parse(List)}.
     */
    @Test
    public void testParseStringPLACEToReportCommand() {

        commands.add("PLACE 1, 1, NORTH");
        commands.add("PLACE 1 , 1,  EAST");
        commands.add("PLACE 1, 1, 3");
        commands.add("PLA 1, 1, SOUTH");

        List<ICommand> parsedCommand = commandParser.parse(commands);

        assertEquals(4, parsedCommand.size());
        assertTrue(parsedCommand.get(0) instanceof PlaceCommand);
        assertTrue(parsedCommand.get(1) instanceof PlaceCommand);
        assertNull(parsedCommand.get(2));
        assertNull(parsedCommand.get(3));
    }

}