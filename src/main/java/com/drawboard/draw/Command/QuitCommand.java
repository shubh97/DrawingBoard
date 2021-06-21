package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;

public class QuitCommand implements Command {

    private CommandProcessor commandProcessor;

    public QuitCommand() {

    }

    public QuitCommand(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public Canvas execute() throws InvalidException {

        return commandProcessor.processCommand();

    }
}
