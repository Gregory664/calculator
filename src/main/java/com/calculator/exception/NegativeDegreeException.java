package com.calculator.exception;

public class NegativeDegreeException extends RuntimeException {
    public NegativeDegreeException() {
        super("Negative degree is not supported");
    }
}
