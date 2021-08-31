package com.isa.supplier.exception;

public class ShiftAlreadyExistsException extends RuntimeException{

    public ShiftAlreadyExistsException(String message) {
        super(message);
    }
}
