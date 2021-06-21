package com.drawboard.draw.Validator;

import com.drawboard.draw.Exception.InvalidException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfArgumentsValidator implements Validator{

    private String mainCommand;
    private List<Integer> args;

    private static final Map<String, Integer> commandAndArgs = createMap();

    private static Map<String, Integer> createMap() {
        Map<String, Integer> result = new HashMap<>();
        result.put("C", 2);
        result.put("L", 4);
        result.put("R", 4);
        result.put("B", 2);
        result.put("Q", 0);
        return Collections.unmodifiableMap(result);
    }


    public NumberOfArgumentsValidator() {

    }

    public NumberOfArgumentsValidator(String mainCommand, List<Integer> args) {
        this.mainCommand = mainCommand;
        this.args = args;
    }

    @Override
    public void validate() throws InvalidException {

        if(commandAndArgs.get(mainCommand)!=args.size())
            throw new InvalidException("Command "+mainCommand+" requires "+Integer.toString(commandAndArgs.get(mainCommand))+" arguments");
    }
}
