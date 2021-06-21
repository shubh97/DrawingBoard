package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;

public class CanvasCommand implements Command {

    private CommandProcessor commandProcessor;

    public CanvasCommand() {

    }

    public CanvasCommand(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public Canvas execute() throws InvalidException {

        return commandProcessor.processCommand();

    }
}
