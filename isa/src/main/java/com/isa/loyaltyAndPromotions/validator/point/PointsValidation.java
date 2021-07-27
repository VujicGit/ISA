package com.isa.loyaltyAndPromotions.validator.point;

import com.isa.loyaltyAndPromotions.validator.point.ValidationClass;

import javax.persistence.Column;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = ValidationClass.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface PointsValidation {

    String message() default "Point can not be lower than 0";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
