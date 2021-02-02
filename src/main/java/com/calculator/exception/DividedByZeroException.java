package com.calculator.exception;

public class DividedByZeroException extends RuntimeException {
    public DividedByZeroException() {
        super("Divided by zero!");
    }
}
