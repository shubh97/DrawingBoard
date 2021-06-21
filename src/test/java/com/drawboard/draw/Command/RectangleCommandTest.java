package com.drawboard.draw.Command;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Exception.InvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class RectangleCommandTest {
    CommandProcessor cp;
    Canvas canvas;
    List<Integer> parameters;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void commandSetup()
    {
        canvas = new Canvas();
        canvas.setHeight(4);
        canvas.setWidth(4);
        canvas.init();
        parameters = new ArrayList<>();
        parameters.add(1);
        parameters.add(1);
        parameters.add(3);
        parameters.add(3);
        cp = new CommandProcessor("R", parameters, canvas);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void createRectangleTest() throws InvalidException {
        Command rectangleCommand = new RectangleCommand(cp);
        rectangleCommand.execute().display();

        Assertions.assertEquals(outputStreamCaptor.toString().trim(), "------\n" +
                "|xxx |\n" +
                "|x x |\n" +
                "|xxx |\n" +
                "|    |\n" +
                "------");
    }
}
