package com.isa.supplier.validator.quantity;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidationClass.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface QuantityValidation {

    String message() default "Quantity must be greater than 0";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
