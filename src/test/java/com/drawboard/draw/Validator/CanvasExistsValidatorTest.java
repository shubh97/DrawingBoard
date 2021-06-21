package com.drawboard.draw.Validator;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CanvasExistsValidatorTest {

    //valid
    @Test
    void createCanvasTest() throws InvalidException {
        Canvas canvas = new Canvas();

        CanvasExistsValidator canvasexistsValidator = new CanvasExistsValidator("C", canvas);

        canvasexistsValidator.validate();

    }

    //L, R, B commands when no canvas
    @Test
    void createCanvasTest2() throws InvalidException {
        Canvas canvas = new Canvas();

        CanvasExistsValidator canvasexistsValidator = new CanvasExistsValidator("L", canvas);

        Assert.assertThrows(InvalidException.class, ()->{canvasexistsValidator.validate();});

    }
}
