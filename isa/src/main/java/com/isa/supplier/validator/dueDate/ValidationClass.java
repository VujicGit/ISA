package com.isa.supplier.validator.dueDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ValidationClass implements ConstraintValidator<DueDateValidation, LocalDate> {
    @Override
    public void initialize(DueDateValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate currentLocalDate = LocalDate.now();

        return date.isAfter(currentLocalDate);
    }
}
