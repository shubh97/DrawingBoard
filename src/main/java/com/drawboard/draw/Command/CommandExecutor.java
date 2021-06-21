package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    private final List<Command> commands = new ArrayList<>();

    public Canvas executeCommand(Command command) throws InvalidException {
        commands.add(command);
        return command.execute();
    }

}
