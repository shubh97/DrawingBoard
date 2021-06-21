package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;

public class RectangleCommand implements Command {

    private CommandProcessor commandProcessor;

    public RectangleCommand() {

    }

    public RectangleCommand(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public Canvas execute() throws InvalidException {

        return commandProcessor.processCommand();

    }

}
