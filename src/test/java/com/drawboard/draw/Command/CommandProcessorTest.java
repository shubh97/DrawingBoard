package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;


public class CommandProcessorTest {

    CommandProcessor cp;
    Canvas canvas;
    List<Integer> parameters;

    @BeforeEach
    void commandSetup()
    {
        canvas = new Canvas();
        parameters = new ArrayList<>();
        canvas.setWidth(8);
        canvas.setHeight(8);
        canvas.init();
    }

    //valid command to create canvas
    @Test
    void processCanvasCommandTest() throws InvalidException {
        parameters.add(4);
        parameters.add(7);
        cp = new CommandProcessor("C", parameters, canvas);
        cp.processCanvasCommand();
    }

    //negative dimensions for canvas
    @Test
    void processCanvasCommandTest2() throws InvalidException {
        parameters.add(-4);
        parameters.add(7);
        cp = new CommandProcessor("C", parameters, canvas);
        Assert.assertThrows(InvalidException.class, ()->{cp.processCanvasCommand();});
    }

    //valid command to create line
    @Test
    void processLineCommandTest() throws InvalidException {
        parameters.add(4);
        parameters.add(7);
        parameters.add(6);
        parameters.add(7);
        cp = new CommandProcessor("L", parameters, canvas);
        cp.processLineCommand();
    }

    //out of bounds coordinates
    @Test
    void processCanvasLineTest2() throws InvalidException {
        parameters.add(-4);
        parameters.add(7);
        parameters.add(6);
        parameters.add(7);
        cp = new CommandProcessor("L", parameters, canvas);
        Assert.assertThrows(InvalidException.class, ()->{cp.processLineCommand();});
    }

    //diagonal line
    @Test
    void processCanvasLineTest3() throws InvalidException {
        parameters.add(1);
        parameters.add(1);
        parameters.add(2);
        parameters.add(2);
        cp = new CommandProcessor("L", parameters, canvas);
        Assert.assertThrows(InvalidException.class, ()->{cp.processLineCommand();});
    }

    //valid command to create rectangle
    @Test
    void processRectangleCommandTest() throws InvalidException {
        parameters.add(4);
        parameters.add(6);
        parameters.add(5);
        parameters.add(7);
        cp = new CommandProcessor("R", parameters, canvas);
        cp.processRectangleCommand();
    }

    //out of bounds coordinates
    @Test
    void processRectangleLineTest2() throws InvalidException {
        parameters.add(-4);
        parameters.add(7);
        parameters.add(6);
        parameters.add(7);
        cp = new CommandProcessor("R", parameters, canvas);
        Assert.assertThrows(InvalidException.class, ()->{cp.processRectangleCommand();});
    }

    //rectangle too narrow
    @Test
    void processRectangleLineTest3() throws InvalidException {
        parameters.add(1);
        parameters.add(1);
        parameters.add(1);
        parameters.add(2);
        cp = new CommandProcessor("R", parameters, canvas);
        Assert.assertThrows(InvalidException.class, ()->{cp.processRectangleCommand();});
    }

    //valid command to create rectangle
    @Test
    void processBucketCommandTest() throws InvalidException {
        parameters.add(4);
        parameters.add(6);
        canvas.setColor("o");
        cp = new CommandProcessor("B", parameters, canvas);
        cp.processBucketCommand();
    }

    //out of bounds coordinates
    @Test
    void processBucketLineTest2() throws InvalidException {
        parameters.add(-4);
        parameters.add(7);
        cp = new CommandProcessor("B", parameters, canvas);
        Assert.assertThrows(InvalidException.class, ()->{cp.processBucketCommand();});
    }

}
