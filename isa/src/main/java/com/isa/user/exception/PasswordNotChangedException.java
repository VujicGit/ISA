package com.isa.user.exception;

public class PasswordNotChangedException extends RuntimeException{

    public PasswordNotChangedException(String message) {
        super(message);
    }
}
