package org.shopping_guru.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    private static final long serialVersionUID = 4982535076351442826L;

    public UserAlreadyExistsException() {super();}

    public UserAlreadyExistsException(String message) {super(message);}

    public UserAlreadyExistsException(Throwable cause) {super(cause);}

    public UserAlreadyExistsException(String message, Throwable cause) {super(message, cause);}
}
