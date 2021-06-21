package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;
import com.drawboard.draw.Validator.*;

import java.util.List;

public class CommandProcessor {
    private String mainCommand;
    private List<Integer> parameters;
    public Canvas canvas;

    public CommandProcessor() {

    }

    public CommandProcessor(String mainCommand, List<Integer> parameters, Canvas canvas) {
        this.mainCommand = mainCommand;
        this.parameters = parameters;
        this.canvas = canvas;
    }

    public String getMainCommand()
    {
        return mainCommand;
    }

    public Canvas processCommand() throws InvalidException {
        switch (mainCommand) {
            case "C":
                return processCanvasCommand();
            case "L":
                return processLineCommand();
            case "R":
                return processRectangleCommand();
            case "B":
                return processBucketCommand();
            case "Q":
                processQuitCommand();
            default:
                throw new InvalidException("change this");
        }

    }

    public Canvas processCanvasCommand() throws InvalidException {
        Validator canvasDimensionValidator = new CanvasDimensionValidator(parameters);
        canvasDimensionValidator.validate();
        canvas.setHeight(parameters.get(1));
        canvas.setWidth(parameters.get(0));
        canvas.init();
        return canvas;
    }

    public Canvas processLineCommand() throws InvalidException {
        Validator notOutOfBoundsValidator1 = new NotOutOfBoundsValidator(parameters.get(0), parameters.get(1), canvas.getWidth(), canvas.getHeight());
        notOutOfBoundsValidator1.validate();
        Validator notOutOfBoundsValidator2 = new NotOutOfBoundsValidator(parameters.get(2), parameters.get(3), canvas.getWidth(), canvas.getHeight());
        notOutOfBoundsValidator2.validate();
        Validator notDiagonalValidator = new NotDiagonalValidator(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
        notDiagonalValidator.validate();

        canvas.draw(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));

        return canvas;
    }

    public Canvas processRectangleCommand() throws InvalidException {
        Validator notOutOfBoundsValidator1 = new NotOutOfBoundsValidator(parameters.get(0), parameters.get(1), canvas.getWidth(), canvas.getHeight());
        notOutOfBoundsValidator1.validate();
        Validator notOutOfBoundsValidator2 = new NotOutOfBoundsValidator(parameters.get(2), parameters.get(3), canvas.getWidth(), canvas.getHeight());
        notOutOfBoundsValidator2.validate();
        Validator narrowRectangleValidator = new NarrowRectangleValidator(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(3));
        narrowRectangleValidator.validate();

        canvas.draw(parameters.get(0), parameters.get(1), parameters.get(0), parameters.get(3));
        canvas.draw(parameters.get(0), parameters.get(1), parameters.get(2), parameters.get(1));
        canvas.draw(parameters.get(0), parameters.get(3), parameters.get(2), parameters.get(3));
        canvas.draw(parameters.get(2), parameters.get(1), parameters.get(2), parameters.get(3));

        return canvas;
    }

    public Canvas processBucketCommand() throws InvalidException {
        Validator notOutOfBoundsValidator = new NotOutOfBoundsValidator(parameters.get(0), parameters.get(1), canvas.getWidth(), canvas.getHeight());
        notOutOfBoundsValidator.validate();

        String currentColor = canvas.getCellColor(parameters.get(0), parameters.get(1));

        if(currentColor.equals(canvas.getColor()))
            return canvas;

        canvas.fill(parameters.get(0), parameters.get(1), currentColor);

        return canvas;
    }

    public void processQuitCommand() {
        System.exit(0);
    }

}
