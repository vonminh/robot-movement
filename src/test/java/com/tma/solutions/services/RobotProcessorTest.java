package com.tma.solutions.services;

import com.tma.solutions.dimension.SurfaceTable;
import com.tma.solutions.robot.Robot;
import com.tma.solutions.utils.InputUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tests {@link RobotProcessor}
 *
 * @author vnminh
 */
public class RobotProcessorTest {

    private Robot testRobot;

    /**
     * Sets up before run a single test.
     */
    @Before
    public void setUp() {
        SurfaceTable surfaceTable = new SurfaceTable(5, 5);
        testRobot = new Robot(surfaceTable);
    }

    /**
     * Test {@link RobotProcessor#process(Robot, List)}.
     *
     * @throws IOException if any error occurs.
     */
    @Test
    public void testProcess() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("testInput_ok.txt").getFile());
        List<String> commands = InputUtils.collectInputFromFile(file.getAbsolutePath());

        RobotProcessor robotProcessor = new RobotProcessor();
        robotProcessor.process(testRobot, commands);

        String expectedResult = "3 3 NORTH";
        assertEquals(expectedResult, testRobot.currentLocation());
    }

}