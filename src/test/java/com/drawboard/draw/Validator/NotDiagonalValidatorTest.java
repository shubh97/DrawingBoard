package com.drawboard.draw.Validator;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NotDiagonalValidatorTest {

    //valid
    @Test
    void createLineTest() throws InvalidException {
        NotDiagonalValidator notDiagonalValidator = new NotDiagonalValidator(1, 1, 1, 2);

        notDiagonalValidator.validate();
    }

    //Rectangle too narrow
    @Test
    void createLineTest2() throws InvalidException {
        NotDiagonalValidator notDiagonalValidator = new NotDiagonalValidator(1, 1, 2, 2);

        Assert.assertThrows(InvalidException.class, ()->{notDiagonalValidator.validate();});
    }
}
