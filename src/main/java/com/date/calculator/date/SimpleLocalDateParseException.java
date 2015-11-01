package com.date.calculator.date;

public class SimpleLocalDateParseException extends RuntimeException {
    public SimpleLocalDateParseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SimpleLocalDateParseException(final String message) {
        super(message);
    }
}
