package com.isa.helper;

import org.postgresql.util.PSQLException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<?> handle(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        Collection<Error> errorMessages = new ArrayList<>();
        for(ConstraintViolation<?> it : constraintViolations) {
            errorMessages.add(new Error(it.getMessageTemplate()));
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = {PSQLException.class})
    protected ResponseEntity<?> handle2(PSQLException ex) {

        return new ResponseEntity<>(new Error(ex.getServerErrorMessage().getMessage()), HttpStatus.BAD_REQUEST);
    }
}