package io.block16.blockinfoj.exceptions;

public class ConflictException extends RuntimeException {
    public ConflictException() {
    }

    public ConflictException(String message) {
        super(message);
    }
}
