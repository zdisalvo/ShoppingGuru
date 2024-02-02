package org.shopping_guru.exceptions;

public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7001046115551483083L;

    public ProductNotFoundException() {super();}

    public ProductNotFoundException(String message) {super(message);}

    public ProductNotFoundException(Throwable cause) {super(cause);}

    public ProductNotFoundException(String message, Throwable cause) {super(message, cause);}
}
