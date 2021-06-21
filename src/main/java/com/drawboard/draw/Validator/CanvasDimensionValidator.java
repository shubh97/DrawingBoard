package com.drawboard.draw.Validator;

import com.drawboard.draw.Exception.InvalidException;

import java.util.List;

public class CanvasDimensionValidator implements Validator{

    private List<Integer> parameters;

    public CanvasDimensionValidator(List<Integer> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void validate() throws InvalidException {
        if(!(parameters.get(0)>0 && parameters.get(1)>0))
            throw new InvalidException("Enter positive dimensions for Canvas!");
    }
}
