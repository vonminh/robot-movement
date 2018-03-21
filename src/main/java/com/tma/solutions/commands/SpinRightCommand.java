package com.tma.solutions.commands;

import com.tma.solutions.robot.Robot;

public class SpinRightCommand implements ICommand {

    public void execute(Robot robot) {
        robot.spinRight();
    }
}
