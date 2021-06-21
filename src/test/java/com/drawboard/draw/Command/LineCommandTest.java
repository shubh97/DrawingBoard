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

public class LineCommandTest {
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
        parameters.add(1);
        parameters.add(3);
        cp = new CommandProcessor("L", parameters, canvas);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void createLineTest() throws InvalidException {
        Command lineCommand = new LineCommand(cp);
        lineCommand.execute().display();

        Assertions.assertEquals(outputStreamCaptor.toString().trim(), "------\n" +
                "|x   |\n" +
                "|x   |\n" +
                "|x   |\n" +
                "|    |\n" +
                "------");
    }
}
