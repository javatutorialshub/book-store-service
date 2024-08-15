package com.javatutorialshub.bookstore.core.validator;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class ValidationException extends Exception {
    @Getter
    @Setter
    private Set<FieldConstraint> fieldConstraints;

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }

    public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
