package com.drawboard.draw.Validator;

import com.drawboard.draw.Exception.InvalidException;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CanvasDimensionValidatorTest {

    //valid
    @Test
    void createCanvasTest() throws InvalidException {
        List<Integer> parameters = new ArrayList<>();
        parameters.add(6);
        parameters.add(6);

        CanvasDimensionValidator canvasDimensionValidator = new CanvasDimensionValidator(parameters);

        canvasDimensionValidator.validate();

    }

    //negative dimensions
    @Test
    void createCanvasTest2() throws InvalidException {
        List<Integer> parameters = new ArrayList<>();
        parameters.add(-1);
        parameters.add(6);

        CanvasDimensionValidator canvasDimensionValidator = new CanvasDimensionValidator(parameters);

        Assert.assertThrows(InvalidException.class, ()->{canvasDimensionValidator.validate();});

    }

}
