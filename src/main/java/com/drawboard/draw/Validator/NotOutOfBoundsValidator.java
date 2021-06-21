package com.drawboard.draw.Validator;

import com.drawboard.draw.Exception.InvalidException;

public class NotOutOfBoundsValidator implements Validator {

    private int x;
    private int y;
    private int width;
    private int height;

    public NotOutOfBoundsValidator(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void validate() throws InvalidException {
        if(x<=0||x>width||y<=0||y>height)
            throw new InvalidException("Coordinates out of bound!");
    }
}
