package com.isa.supplier.validator.quantity;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationClass implements ConstraintValidator<QuantityValidation, Integer> {
    @Override
    public void initialize(QuantityValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer i, ConstraintValidatorContext constraintValidatorContext) {
        return i > 0;
    }
}
