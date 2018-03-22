package com.tma.solutions;

import com.tma.solutions.dimension.SurfaceTable;
import com.tma.solutions.robot.Robot;
import com.tma.solutions.services.RobotProcessor;
import com.tma.solutions.utils.InputUtils;
import com.tma.solutions.utils.StringUtils;

import java.io.IOException;
import java.util.List;

/**
 * Main class which will trigger the application.
 *
 * @author vnminh
 */
public class Application {

    public static void main(String[] args) {

        String filePath = args[0];

        int topRightX = 5, topRightY = 5;

        if (args.length == 3) {
            if (StringUtils.isNumeric(args[1])) {
                topRightX = Integer.parseInt(args[1]);
            }

            if (StringUtils.isNumeric(args[2])) {
                topRightY = Integer.parseInt(args[2]);
            }
        }

        try {
            List<String> commandInputs = InputUtils.collectInputFromFile(filePath);

            SurfaceTable testTable = new SurfaceTable(topRightX, topRightY);
            Robot robot = new Robot(testTable);

            RobotProcessor robotProcessor = new RobotProcessor();
            robotProcessor.process(robot, commandInputs);
        } catch (IOException ioException) {
            System.out.println("Cannot read file from " + filePath + ": " + ioException.getMessage());
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
