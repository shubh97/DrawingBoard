package com.drawboard.draw.Validator;

import com.drawboard.draw.Exception.InvalidException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NumberOfArgumentsValidatorTest {
    //valid
    @Test
    void numOfArgsTest() throws InvalidException {
        List<Integer> parameters = new ArrayList<>();
        parameters.add(6);
        parameters.add(6);

        NumberOfArgumentsValidator numberOfArgumentsValidator = new NumberOfArgumentsValidator("C", parameters);

        numberOfArgumentsValidator.validate();
    }

    //wrong number of parameters
    @Test
    void numOfArgsTest2() throws InvalidException {
        List<Integer> parameters = new ArrayList<>();
        parameters.add(6);
        parameters.add(6);
        parameters.add(6);

        NumberOfArgumentsValidator numberOfArgumentsValidator = new NumberOfArgumentsValidator("C", parameters);

        Assert.assertThrows(InvalidException.class, ()->{numberOfArgumentsValidator.validate();});
    }
}
