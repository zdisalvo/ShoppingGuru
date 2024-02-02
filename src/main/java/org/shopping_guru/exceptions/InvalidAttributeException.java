package org.shopping_guru.exceptions;

public class InvalidAttributeException extends InvalidRequestException{

    private static final long serialVersionUID = -3447689158358008367L;

    public InvalidAttributeException() {super();};

    public InvalidAttributeException(String message) {super(message);}

    public InvalidAttributeException(Throwable cause) {super(cause);}

    public InvalidAttributeException(String message, Throwable cause) {super(message, cause);}
}
