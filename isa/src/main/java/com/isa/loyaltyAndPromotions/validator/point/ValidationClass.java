package com.isa.loyaltyAndPromotions.validator.point;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationClass implements ConstraintValidator<PointsValidation, Integer> {
    @Override
    public void initialize(PointsValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer points, ConstraintValidatorContext constraintValidatorContext) {
        if (points == null) {
            return false;
        }
        return points > 0;
    }
}
