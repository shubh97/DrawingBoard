package com.drawboard.draw.Exception;

public class InvalidException extends Exception {
    public InvalidException(String errorMessage) {
        super(errorMessage);
    }
    public InvalidException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
