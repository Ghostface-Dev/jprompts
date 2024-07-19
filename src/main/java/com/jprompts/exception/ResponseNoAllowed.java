package com.jprompts.exception;

public class ResponseNoAllowed extends RuntimeException {
    public ResponseNoAllowed(String message) {
        super(message);
    }
}
