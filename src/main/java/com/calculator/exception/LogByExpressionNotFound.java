package com.calculator.exception;

public class LogByExpressionNotFound extends RuntimeException {
    public LogByExpressionNotFound(String expression) {
        super(String.format("Log by expression: %s not found!", expression));
    }
}
