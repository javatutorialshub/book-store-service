package com.javatutorialshub.bookstore.core.feature.update;

public class UpdateBookException extends Exception {
    public UpdateBookException() {
    }

    public UpdateBookException(String message) {
        super(message);
    }

    public UpdateBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateBookException(Throwable cause) {
        super(cause);
    }

    public UpdateBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
