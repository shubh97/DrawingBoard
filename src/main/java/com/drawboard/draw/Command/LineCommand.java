package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;

public class LineCommand implements Command {

    private CommandProcessor commandProcessor;

    public LineCommand() {

    }

    public LineCommand(CommandProcessor commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public Canvas execute() throws InvalidException {

        return commandProcessor.processCommand();

    }

}
