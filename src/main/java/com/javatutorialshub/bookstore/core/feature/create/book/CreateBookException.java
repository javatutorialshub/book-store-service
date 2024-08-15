package com.javatutorialshub.bookstore.core.feature.create.book;

public class CreateBookException extends Exception {
    public CreateBookException() {
    }

    public CreateBookException(String message) {
        super(message);
    }

    public CreateBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public CreateBookException(Throwable cause) {
        super(cause);
    }

    public CreateBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
