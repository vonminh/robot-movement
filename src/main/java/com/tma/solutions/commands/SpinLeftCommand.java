package com.tma.solutions.commands;

import com.tma.solutions.robot.Robot;

public class SpinLeftCommand implements ICommand {

    public void execute(Robot robot) {
        robot.spinLeft();
    }
}
