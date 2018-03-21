package com.tma.solutions.commands;

import com.tma.solutions.robot.Robot;

public class MoveCommand implements ICommand {

    public void execute(Robot robot) {
        robot.move(1);
    }
}
