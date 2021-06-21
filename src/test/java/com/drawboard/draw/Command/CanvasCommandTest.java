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

public class CanvasCommandTest {

    CommandProcessor cp;
    Canvas canvas;
    List<Integer> parameters;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void commandSetup()
    {
        canvas = new Canvas();
        parameters = new ArrayList<>();
        parameters.add(5);
        parameters.add(5);
        cp = new CommandProcessor("C", parameters, canvas);

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void createCanvasTest() throws InvalidException {
        Command canvasCommand = new CanvasCommand(cp);
        canvasCommand.execute().display();

        Assertions.assertEquals(outputStreamCaptor.toString().trim(), "-------\n" +
                                                                            "|     |\n" +
                                                                            "|     |\n" +
                                                                            "|     |\n" +
                                                                            "|     |\n" +
                                                                            "|     |\n" +
                                                                            "-------");
    }
}
