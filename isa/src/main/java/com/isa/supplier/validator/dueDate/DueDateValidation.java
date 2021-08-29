package com.isa.supplier.validator.dueDate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidationClass.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DueDateValidation {

    String message() default "Due date must be in future";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
