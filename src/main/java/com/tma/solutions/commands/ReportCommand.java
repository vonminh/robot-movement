package com.tma.solutions.commands;

import com.tma.solutions.robot.Robot;

public class ReportCommand implements ICommand {

    public void execute(Robot robot) {
        System.out.println(robot.currentLocation());
    }
}
