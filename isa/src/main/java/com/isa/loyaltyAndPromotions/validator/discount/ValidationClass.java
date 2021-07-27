package com.isa.loyaltyAndPromotions.validator.discount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationClass implements ConstraintValidator<DiscountValidation, Double> {
    @Override
    public void initialize(DiscountValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Double discountField, ConstraintValidatorContext constraintValidatorContext) {
        if(discountField == null) {
            return false;
        }

        return discountField >= 0 && discountField <= 100;
    }
}
