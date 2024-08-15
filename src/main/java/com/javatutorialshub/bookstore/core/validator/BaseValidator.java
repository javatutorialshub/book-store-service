package com.javatutorialshub.bookstore.core.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.HashSet;
import java.util.Set;

public class BaseValidator<T> {

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public void validate(T data) throws ValidationException {
        if(data == null){
            throw new ValidationException("object cannot be null");
        }
        Set<ConstraintViolation<T>> constraintsViolations = validator.validate(data);
        if(!constraintsViolations.isEmpty()) {
            Set<FieldConstraint> fieldConstraints = HashSet.newHashSet(constraintsViolations.size());
            constraintsViolations.forEach(c -> {
                FieldConstraint fieldConstraint = new FieldConstraint(c.getPropertyPath().toString(), c.getMessage());
                fieldConstraints.add(fieldConstraint);
            });
            ValidationException ex = new ValidationException("Constraints violation occurred when validating content");
            ex.setFieldConstraints(fieldConstraints);
            throw ex;
        }
    }
}
