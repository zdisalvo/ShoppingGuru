package org.shopping_guru.exceptions;

public class InvalidRequestException extends RuntimeException{

    private static final long serialVersionUID = 5532014820211308850L;

    public InvalidRequestException() { super(); };

    public InvalidRequestException(String message) {
        super(message);
    }

    public InvalidRequestException(Throwable cause) {
        super(cause);
    }

    public InvalidRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}