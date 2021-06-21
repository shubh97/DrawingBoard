package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;

//Command class
public interface Command {
    Canvas execute() throws InvalidException;
}
