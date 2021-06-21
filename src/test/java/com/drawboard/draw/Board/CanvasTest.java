package com.drawboard.draw.Board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CanvasTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setup()
    {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void createCanvasTest()
    {
        Canvas canvas = new Canvas();
        canvas.setWidth(6);
        canvas.setHeight(6);
        canvas.init();
        canvas.display();
        Assertions.assertEquals(outputStreamCaptor.toString().trim(),"--------\n" +
                "|      |\n" +
                "|      |\n" +
                "|      |\n" +
                "|      |\n" +
                "|      |\n" +
                "|      |\n" +
                "--------");
    }

    @Test
    void createCreateLineTest()
    {
        Canvas canvas = new Canvas();
        canvas.setWidth(6);
        canvas.setHeight(6);
        canvas.init();
        canvas.draw(1,1, 1, 3);
        canvas.display();
        Assertions.assertEquals(outputStreamCaptor.toString().trim(),"--------\n" +
                "|x     |\n" +
                "|x     |\n" +
                "|x     |\n" +
                "|      |\n" +
                "|      |\n" +
                "|      |\n" +
                "--------");
    }

    //same as above test but coordinates swapped
    @Test
    void createCreateLineTest2()
    {
        Canvas canvas = new Canvas();
        canvas.setWidth(6);
        canvas.setHeight(6);
        canvas.init();
        canvas.draw(1,3, 1, 1);
        canvas.display();
        Assertions.assertEquals(outputStreamCaptor.toString().trim(),"--------\n" +
                "|x     |\n" +
                "|x     |\n" +
                "|x     |\n" +
                "|      |\n" +
                "|      |\n" +
                "|      |\n" +
                "--------");
    }

    @Test
    void fillCanvasTest()
    {
        Canvas canvas = new Canvas();
        canvas.setWidth(6);
        canvas.setHeight(6);
        canvas.init();
        canvas.setColor("o");
        canvas.fill(3, 3, canvas.getCellColor(3, 3));
        canvas.display();
        Assertions.assertEquals(outputStreamCaptor.toString().trim(),"--------\n" +
                "|oooooo|\n" +
                "|oooooo|\n" +
                "|oooooo|\n" +
                "|oooooo|\n" +
                "|oooooo|\n" +
                "|oooooo|\n" +
                "--------");
    }
}
