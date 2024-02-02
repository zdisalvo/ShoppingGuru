package org.shopping_guru.exceptions;

public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = -3779581455245267099L;

    public UserNotFoundException() {super();}

    public UserNotFoundException(String message) {super(message);}

    public UserNotFoundException(Throwable cause) {super(cause);}

    public UserNotFoundException(String message, Throwable cause) {super(message, cause);}
}
