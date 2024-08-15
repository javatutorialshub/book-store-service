package com.javatutorialshub.bookstore.core.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = IsAcceptedValidator.class)
public @interface IsAccepted {
    String[] value();
    String message() default "{com.javatutorialshub.bookstore.core.IsAccepted.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
