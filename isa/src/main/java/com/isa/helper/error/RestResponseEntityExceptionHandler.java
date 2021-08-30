package com.isa.helper.error;

import com.isa.pharmacy.exception.PriceTimeException;
import com.isa.supplier.exception.AdminException;
import com.isa.supplier.exception.OrderNotFoundException;
import com.isa.user.exception.InvalidCredentialsException;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
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

    @ExceptionHandler(value = {NoSuchElementException.class})
    protected ResponseEntity<?> handle3(NoSuchElementException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {PriceTimeException.class})
    protected ResponseEntity<?> handle4(PriceTimeException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {InvalidCredentialsException.class})
    protected ResponseEntity<?> handle5(InvalidCredentialsException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = {OrderNotFoundException.class})
    protected ResponseEntity<?> handle6(OrderNotFoundException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AdminException.class})
    protected ResponseEntity<?> handle7(AdminException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
