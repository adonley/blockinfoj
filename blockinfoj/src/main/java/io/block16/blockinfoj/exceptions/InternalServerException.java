package io.block16.blockinfoj.exceptions;

public class InternalServerException extends RuntimeException {

    public InternalServerException() { }

    public InternalServerException(String message) {
        super(message);
    }
}
