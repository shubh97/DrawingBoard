package com.drawboard.draw;

import com.drawboard.draw.Board.Canvas;
import com.drawboard.draw.Command.*;
import com.drawboard.draw.Exception.InvalidException;
import com.drawboard.draw.Validator.CanvasExistsValidator;
import com.drawboard.draw.Validator.NumberOfArgumentsValidator;
import com.drawboard.draw.Validator.Validator;

import java.util.*;
import java.util.regex.Pattern;

public class Application {

    private static Scanner scanner;
    private static Scanner commandScanner;

    public static void main(String args[]) {

        Application obj = new Application();

        Canvas canvas = new Canvas();

        CommandExecutor commandExecutor = new CommandExecutor();

        scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("Draw command: ");
                commandScanner = new Scanner(scanner.nextLine());
                obj.executeCommand(commandScanner, canvas, commandExecutor);
                canvas.display();
                commandScanner.close();
            }
            catch(Exception e)      //covers NoSuchElement and IllegalState exceptions
            {
                System.out.println(e);
            }
        }
    }

    public void executeCommand(Scanner comm, Canvas canvas, CommandExecutor commandExecutor) throws InvalidException {
        if(!comm.hasNext(Pattern.compile("[CLRBQ]"))) {
            throw new InvalidException("Invalid Command!");
        }
        else {
            String command = comm.next();

            List<Integer> val = new ArrayList<>();

            String color = "";

            while(comm.hasNextInt()) {
                val.add(comm.nextInt());
            }

            if(comm.hasNext()&&!command.equals("B"))
                throw new InvalidException("Invalid Command!");

            if(command.equals("B")) {
                if(comm.hasNext()) {
                    color = comm.next();
                    if (color.length() > 1)
                        throw new InvalidException("Color should be 1 character!");
                    else if(color.equals("x")) {
                        throw new InvalidException("Character x reserved for making lines!");
                    }
                }
                else {
                    throw new InvalidException("Specify color!");
                }
            }

            if(comm.hasNext())
                throw new InvalidException("Invalid Command!");

            canvas.setColor(color);

            Validator numberOfArgs = new NumberOfArgumentsValidator(command, val);
            numberOfArgs.validate();

            if(command.equals("Q")) {
                commandScanner.close();
                scanner.close();
            }

            Validator canvasExists = new CanvasExistsValidator(command, canvas);
            canvasExists.validate();

            CommandProcessor cp = new CommandProcessor(command, val, canvas);

            Command cb = getCommand(cp);

            canvas = commandExecutor.executeCommand(cb);

            //commandExecutor.executeCommand(new LineCommand(new CommandProcessor(command, val, canvas))));

        }
    }

    public Command getCommand(CommandProcessor commandProcessor) throws InvalidException
    {
        switch (commandProcessor.getMainCommand()) {
            case "C":
                return new CanvasCommand(commandProcessor);
            case "L":
                return new LineCommand(commandProcessor);
            case "R":
                return new RectangleCommand(commandProcessor);
            case "B":
                return new BucketCommand(commandProcessor);
            case "Q":
                return new QuitCommand(commandProcessor);
            default:
                throw new InvalidException("Exception!");
        }
    }


}
