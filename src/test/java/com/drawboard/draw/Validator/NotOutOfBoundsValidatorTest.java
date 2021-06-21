package com.drawboard.draw.Validator;

import com.drawboard.draw.Exception.InvalidException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class NotOutOfBoundsValidatorTest {

    //valid
    @Test
    void outOfBoundsTest() throws InvalidException {
        NotOutOfBoundsValidator notOutOfBoundsValidator = new NotOutOfBoundsValidator(5, 5, 5, 5);

        notOutOfBoundsValidator.validate();
    }

    //out of bounds
    @Test
    void outOfBoundsTest2() throws InvalidException {
        NotOutOfBoundsValidator notOutOfBoundsValidator = new NotOutOfBoundsValidator(6, 5, 5, 5);

        Assert.assertThrows(InvalidException.class, ()->{notOutOfBoundsValidator.validate();});
    }
}
