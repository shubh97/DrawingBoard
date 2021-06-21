package com.drawboard.draw;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Command.CommandExecutor;
import com.drawboard.draw.Exception.InvalidException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class ApplicationTest {

    static Canvas canvas;
    static Application obj;
    static CommandExecutor commandExecutor;

    @BeforeEach
    void canvasSetup()
    {
        canvas = new Canvas();
        obj = new Application();
        commandExecutor = new CommandExecutor();
    }

    //Valid command
    @Test
    void executeCommandTest() throws InvalidException {
        Scanner commandScanner = new Scanner("C 5 6");
        obj.executeCommand(commandScanner, canvas, commandExecutor);
    }

    //Invalid command
    @Test
    void executeCommandTest2() throws InvalidException {
        Scanner commandScanner = new Scanner("W 3 4 5 6");
        Assert.assertThrows(InvalidException.class, ()->{obj.executeCommand(commandScanner, canvas, commandExecutor);});
    }

    //Valid command but canvas doesn't exist
    @Test
    void executeCommandTest3() throws InvalidException {
        Scanner commandScanner = new Scanner("L 3 4 5 6");
        Assert.assertThrows(InvalidException.class, ()->{obj.executeCommand(commandScanner, canvas, commandExecutor);});
    }

    //Valid command but wrong number of arguments
    @Test
    void executeCommandTest4() throws InvalidException {
        Scanner commandScanner = new Scanner("Q 3");
        Assert.assertThrows(InvalidException.class, ()->{obj.executeCommand(commandScanner, canvas, commandExecutor);});
    }
}
