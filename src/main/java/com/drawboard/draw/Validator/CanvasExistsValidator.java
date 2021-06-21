package com.drawboard.draw.Validator;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;

public class CanvasExistsValidator implements Validator{

    private String mainCommand;
    private Canvas canvas;

    public CanvasExistsValidator(String mainCommand, Canvas canvas) {
        this.mainCommand = mainCommand;
        this.canvas = canvas;
    }

    @Override
    public void validate() throws InvalidException {
        if(!(canvas.getHeight()>0&&canvas.getWidth()>0) && !mainCommand.equals("C") && !mainCommand.equals("Q"))
            throw new InvalidException("Create canvas first!");
        return;
    }
}
