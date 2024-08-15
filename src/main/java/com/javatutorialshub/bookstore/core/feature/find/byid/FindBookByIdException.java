package com.javatutorialshub.bookstore.core.feature.find.byid;

public class FindBookByIdException extends Exception {
    public FindBookByIdException() {
    }

    public FindBookByIdException(String message) {
        super(message);
    }

    public FindBookByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindBookByIdException(Throwable cause) {
        super(cause);
    }

    public FindBookByIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
