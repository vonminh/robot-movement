package com.tma.solutions;

import com.tma.solutions.dimension.SurfaceTable;
import com.tma.solutions.robot.Robot;
import com.tma.solutions.utils.InputUtils;

import java.io.IOException;
import java.util.List;

/**
 * Main class which will trigger the application.
 *
 * @author vnminh
 */
public class Application {

    public static void main(String[] args) throws IOException {

        String filePath = "C:\\Users\\User\\Documents\\My Documents\\TMA Projects\\commands.txt";
        List<String> inputFromFile = InputUtils.collectInputFromFile(filePath);
        Robot robot = new Robot(new SurfaceTable(5,5));
        robot.run(inputFromFile);
    }


}
