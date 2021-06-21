package com.drawboard.draw.Validator;

import com.drawboard.draw.Exception.InvalidException;

public class NotDiagonalValidator implements Validator{
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public NotDiagonalValidator(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void validate() throws InvalidException {
        if(x1!=x2&&y1!=y2)
            throw new InvalidException("Diagonal lines not allowed!");
    }
}
