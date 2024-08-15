package com.javatutorialshub.bookstore.core.validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.executable.ExecutableValidator;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodParametersValidator {

    private static final ExecutableValidator validator = Validation.buildDefaultValidatorFactory().getValidator().forExecutables();

    public void validate(Object object, Method method, Object[] args) throws ValidationException {
        if(object == null){
            throw new ValidationException("object cannot be null");
        }
        Set<ConstraintViolation<Object>> constraintsViolations = validator.validateParameters(object, method, args);
        MethodResultValidator.handleConstraintsViolations(constraintsViolations);
    }
}
