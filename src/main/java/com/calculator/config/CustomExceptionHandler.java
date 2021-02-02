package com.calculator.config;

import com.calculator.exception.DividedByZeroException;
import com.calculator.exception.LogByExpressionNotFound;
import com.calculator.exception.NegativeDegreeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.EmptyStackException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({DividedByZeroException.class, NegativeDegreeException.class})
    public void handleDividedByZeroException(DividedByZeroException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(LogByExpressionNotFound.class)
    public void handleLogByExpressionNotFound(LogByExpressionNotFound e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(EmptyStackException.class)
    public void handleEmptyStackException(EmptyStackException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "not correct expression!");
    }


}
