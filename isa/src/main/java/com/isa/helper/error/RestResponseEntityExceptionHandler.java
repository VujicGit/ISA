package com.isa.helper.error;

import com.isa.appointment.exception.ExaminationException;
import com.isa.pharmacy.exception.PriceTimeException;
import com.isa.user.exception.VacationRequestException;
import com.isa.supplier.exception.AdminException;
import com.isa.supplier.exception.OrderNotFoundException;
import com.isa.user.exception.AlreadyEmployedException;
import com.isa.user.exception.ShiftAlreadyExistsException;
import com.isa.user.exception.InvalidCredentialsException;
import com.isa.user.exception.ShiftsOverlappingException;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
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

    @ExceptionHandler(value = {VacationRequestException.class})
    protected ResponseEntity<?> handle5(VacationRequestException ex) {
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

    @ExceptionHandler(value = {ShiftAlreadyExistsException.class})
    protected ResponseEntity<?> handle8(ShiftAlreadyExistsException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ShiftsOverlappingException.class})
    protected ResponseEntity<?> handle9(ShiftsOverlappingException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<?> handle10(RuntimeException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AuthenticationException.class})
    protected ResponseEntity<?> handleAuthenticationException(AuthenticationException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ExaminationException.class})
    protected ResponseEntity<?> handleExaminationException(ExaminationException ex) {
        return new ResponseEntity<>(new Error(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
