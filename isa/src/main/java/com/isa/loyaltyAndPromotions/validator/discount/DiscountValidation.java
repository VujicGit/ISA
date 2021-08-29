package com.isa.loyaltyAndPromotions.validator.discount;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidationClass.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DiscountValidation {

    String message() default "Discount can not be greater than 100 and lower than 0";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
