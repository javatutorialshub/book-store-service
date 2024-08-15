package com.javatutorialshub.bookstore.core.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.executable.ExecutableValidator;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class MethodResultValidator {

    private static final ExecutableValidator validator = Validation.buildDefaultValidatorFactory().getValidator().forExecutables();

    public void validate(Object object, Method method, Object result) throws ValidationException {
        if(object == null){
            throw new ValidationException("object cannot be null");
        }
        Set<ConstraintViolation<Object>> constraintsViolations = validator.validateReturnValue(object, method, result);
        handleConstraintsViolations(constraintsViolations);
    }

    protected static <T> void handleConstraintsViolations(Set<ConstraintViolation<T>> constraintsViolations) throws ValidationException {
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
