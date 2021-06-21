package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;

public class BucketCommand implements Command {

    private CommandProcessor commandProcessor;

    public BucketCommand() {

    }

    public BucketCommand(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public Canvas execute() throws InvalidException {

        return commandProcessor.processCommand();

    }
}
