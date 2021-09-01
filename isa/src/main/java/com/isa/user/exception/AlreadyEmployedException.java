package com.isa.user.exception;

public class AlreadyEmployedException extends RuntimeException{

    public AlreadyEmployedException(String message) {
        super(message);
    }
}
