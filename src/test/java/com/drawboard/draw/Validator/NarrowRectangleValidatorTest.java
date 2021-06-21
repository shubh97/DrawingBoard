package com.drawboard.draw.Validator;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NarrowRectangleValidatorTest {

    //valid
    @Test
    void createRectangleTest() throws InvalidException {
        NarrowRectangleValidator narrowRectangleValidator = new NarrowRectangleValidator(1, 1, 2, 2);

        narrowRectangleValidator.validate();
    }

    //Rectangle too narrow
    @Test
    void createRectangleTest2() throws InvalidException {
        NarrowRectangleValidator narrowRectangleValidator = new NarrowRectangleValidator(1, 1, 1, 2);

        Assert.assertThrows(InvalidException.class, ()->{narrowRectangleValidator.validate();});
    }
}
